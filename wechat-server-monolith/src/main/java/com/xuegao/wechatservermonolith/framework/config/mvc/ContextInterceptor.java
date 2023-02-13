package com.xuegao.wechatservermonolith.framework.config.mvc;

import com.xuegao.core.exception.ServiceException;
import com.xuegao.core.model.Context;
import com.xuegao.core.model.ContextUtil;
import com.xuegao.core.model.FmkUserInfo;
import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.util.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ContextInterceptor implements HandlerInterceptor, Ordered {
    private static final Logger log = LoggerFactory.getLogger(ContextInterceptor.class);

    /**
     * 最先执行
     * preHandle
     *
     * @param request:
     * @param response:
     * @param handler:
     * @return boolean
     * @author xuegao
     * @date 2022/11/14 21:39
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (RequestMethod.OPTIONS.name().equals(request.getMethod())) {
            return true;
        }
        System.out.println(Thread.currentThread().getName() + " == preHandle === " + getClass().getName() + " == " + request.getRequestURI() + " === " + request.getMethod());

        String userId = request.getHeader(FmkUserInfo.KEY_USER_ID);
        String username = request.getHeader(FmkUserInfo.KEY_USERNAME);
        String userNumber = request.getHeader(FmkUserInfo.KEY_USER_NUMBER);
        String nickname = request.getHeader(FmkUserInfo.KEY_NICKNAME);
        String phone = request.getHeader(FmkUserInfo.KEY_PHONE);
        String ip = request.getHeader(FmkUserInfo.KEY_IP);

        String token = request.getHeader(FmkUserInfo.KEY_TOKEN);

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(token)) {
            log.info("[wechat-server-monolith][ContextInterceptor][preHandle][userId={}]", userId);
            throw new ServiceException("请登录后尝试");
        }
        Context context = ContextUtil.get();
        log.info("[wechat-server-monolith][ContextInterceptor][preHandle][context1={}]", JsonUtil.toJsonString(context));
        FmkUserInfo fmkUserInfo = new FmkUserInfo();
        fmkUserInfo.setUserId(userId);
        fmkUserInfo.setUserNumber(userNumber);
        fmkUserInfo.setUsername(username);
        fmkUserInfo.setNickname(nickname);
        fmkUserInfo.setPhone(phone);
        fmkUserInfo.setIpAdder(ip);
        context.setFmkUserInfo(fmkUserInfo);

        context.setToken(token);

        ContextUtil.set(context);
        log.info("[wechat-server-monolith][ContextInterceptor][preHandle][context2={}]", JsonUtil.toJsonString(context));
        TokenUtil.saveUserIdAndToken(userId, token);
        // 注意 这里必须是true否则请求将就此终止。
        return true;
    }

    /**
     * 控制器的处理请求方法执行完成后执行
     * afterCompletion
     *
     * @param request:
     * @param response:
     * @param handler:
     * @param ex:
     * @author xuegao
     * @date 2022/11/14 21:40
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex)
            throws Exception {
        if (RequestMethod.OPTIONS.name().equals(request.getMethod())) {
            return;
        }
        System.out.println(Thread.currentThread().getName() + " == afterCompletion === " + getClass().getName() + " == " + request.getRequestURI() + " === " + request.getMethod());
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (RequestMethod.OPTIONS.name().equals(request.getMethod())) {
            return;
        }
        System.out.println(Thread.currentThread().getName() + " == postHandle === " + getClass().getName() + " == " + request.getRequestURI() + " === " + request.getMethod());
    }

    @Override
    public int getOrder() {
        // 通过配置order()的值，值越小，优先级越高。不配默认是0
        int i = Integer.MIN_VALUE;
        System.out.println(getClass().getName() + " == " + i);
        return i;
    }
}