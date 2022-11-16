package com.xuegao.wechatservermonolith.framework.config.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TestLastInterceptor implements HandlerInterceptor, Ordered {
    private static final Logger log = LoggerFactory.getLogger(TestLastInterceptor.class);

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
        log.info("[xuegao-im-chat-v2][TestLastInterceptor][preHandle][order={}]", getOrder());
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
        System.out.println("afterCompletion方法在控制器的处理请求方法执行完成后执行，即视图渲染结束之后执行");
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle方法在控制器的处理请求方法调用之后，解析视图之前执行");
    }


    @Override
    public int getOrder() {
        return 1;
    }
}