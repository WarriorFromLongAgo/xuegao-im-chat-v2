package com.xuegao.wechatservermonolith.sysuser.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.core.common.FmkConstant;
import com.xuegao.core.exception.ServiceException;
import com.xuegao.core.model.Context;
import com.xuegao.core.model.ContextUtil;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.util.JsonUtil;
import com.xuegao.util.UuidUtil;
import com.xuegao.util.time.LocalDateTimeUtil;
import com.xuegao.wechatservermonolith.common.model.sysuser.bo.SysUserBO;
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import com.xuegao.wechatservermonolith.common.model.sysuser.dto.SysLoginDTO;
import com.xuegao.wechatservermonolith.common.model.sysuser.vo.LoginInfoVO;
import com.xuegao.wechatservermonolith.sysuser.check.SysUserCheckService;
import com.xuegao.wechatservermonolith.sysuser.manage.SysUserMpManage;
import com.xuegao.wechatservermonolith.util.TokenUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class SysUserService {
    private static final Logger log = LoggerFactory.getLogger(SysUserService.class);

    @Autowired
    private SysUserMpManage sysUserMpManage;

    @Autowired
    @Qualifier(value = FmkConstant.XUEGAO_THREAD_NAME_BEAN)
    private Executor xuegaoSpringTaskExecutor;

    @Autowired
    private SysUserCheckService sysUserCheckService;

    public LoginInfoVO login(SysLoginDTO sysLoginDTO) {
        log.info("[xuegao-im-chat-v2][SysUserService][login][sysLoginDTO={}]", JsonUtil.toJsonString(sysLoginDTO));
        sysUserCheckService.checkIsNull("入参不能为空", sysLoginDTO);
        sysUserCheckService
                .checkIsNull("用户名或者昵称不能为空", sysLoginDTO.getUsername())
        // .checkIsNull("用户名或者昵称不能为空", sysLoginDTO.getNickname())
        ;

        // List<?> list = Lists.newArrayList("1", "2");
        // list.stream().map(new Function<Object, JsonbHttpMessageConverter>() {
        //     @Override
        //     public JsonbHttpMessageConverter apply(Object o) {
        //         return (JsonbHttpMessageConverter) o;
        //     }
        // }).forEach(new Consumer<JsonbHttpMessageConverter>() {
        //     @Override
        //     public void accept(JsonbHttpMessageConverter s) {
        //         s.getJsonb()
        //     }
        // });

        SysUserBO dbSysUser = sysUserMpManage.getByUsernameOrNickName(sysLoginDTO.getUsername(), sysLoginDTO.getNickname());
        if (ObjectUtils.isEmpty(dbSysUser)) {
            throw new ServiceException("登录用户不存在");
        }
        String token = UUID.randomUUID().toString();
        LoginInfoVO loginInfoVO = new LoginInfoVO();
        loginInfoVO.setToken(token);
        loginInfoVO.setSysUser(dbSysUser);

        TokenUtil.saveUserIdAndToken(dbSysUser.getId().toString(), token);

        Context context = ContextUtil.get();

        CompletableFuture
                .runAsync(() -> {
                            log.info("[xuegao-im-chat-v2][SysUserService][login][={}]", Thread.currentThread().getName());
                            String contextStr = JsonUtil.toJsonString(ContextUtil.get());
                            log.info("[xuegao-im-chat-v2][SysUserService][login][context1={}]", contextStr);
                            ContextUtil.set(context);
                            String contextStr2 = JsonUtil.toJsonString(ContextUtil.get());
                            log.info("[xuegao-im-chat-v2][SysUserService][login][context2={}]", contextStr2);
                            SysUserBO update = new SysUserBO();
                            update.setId(dbSysUser.getId());
                            dbSysUser.setLastLoginTime(LocalDateTimeUtil.now());
                            sysUserMpManage.updateByIdService(dbSysUser);
                        },
                        xuegaoSpringTaskExecutor)
                .exceptionally(throwable -> {
                    log.error("[xuegao-im-chat-v2][SysUserService][login apply][exceptionally]", throwable);
                    return null;
                });

        return loginInfoVO;
    }

    public Integer registerService(SysUserBO inputSysUser) {
        sysUserCheckService.checkIsNull("入参不能为空", inputSysUser);
        sysUserCheckService
                .checkIsNull("用户名不能为空", inputSysUser.getUsername())
                .checkIsNull("昵称不能为空", inputSysUser.getNickname())
        ;

        SysUserBO usernameOrNickName = sysUserMpManage.getByUsernameOrNickName(inputSysUser.getUsername(), inputSysUser.getNickname());
        try {
            sysUserCheckService.checkIsNotNull("用户名或者昵称已存在", usernameOrNickName);
        } catch (Exception e) {
            log.info("[xuegao-im-chat-v2][SysUserService][registerService][e={}]", e.getMessage(), e);
            throw new ServiceException("用户名或者昵称已存在");
        }
        log.info("[xuegao-im-chat-v2][SysUserService][registerService][1111111111111111111111111111]");

        SysUser insert = new SysUser();
        insert.setUsername(inputSysUser.getUsername());
        // 网站不需要填密码
        insert.setPassword("123456");
        insert.setNickname(inputSysUser.getUsername());
        insert.setUid(UuidUtil.uuid());
        sysUserMpManage.mpInsert(insert);
        log.info("[xuegao-im-chat-v2][SysUserService][registerService][inputSysUser={}]", JsonUtil.toJsonString(inputSysUser));
        return 1;
    }

    public int updateService(SysUserBO sysUser) {
        return sysUserMpManage.updateService(sysUser);
    }

    public int batchDisableService(GenericModelDTO<SysUserBO> dto) {
        // sysUserMpManage.mpDisable(dto.getIds());
        return 1;
    }

    public List<SysUserBO> listService(GenericModelDTO<SysUserBO> dto) {
        // sysUserMpManage.mpGetByIds(dto.getIds());
        log.info("[xuegao-im-chat-v2][SysUserService][listService][]");
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                log.info("[xuegao-im-chat-v2][SysUserService][run][listService1=]");
            }
        });
        xuegaoSpringTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                log.info("[xuegao-im-chat-v2][SysUserService][run][listService2=]");
            }
        });


        return Lists.newArrayList();
    }

    public Page<SysUserBO> searchService(GenericModelDTO<SysUserBO> dto) {
        // sysUserMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }

    public SysUserBO getUserByToken() {
        Context context = ContextUtil.get();
        String token = context.getToken();
        String userId = TokenUtil.getUserIdByToken(token);
        if (StringUtils.isBlank(userId)) {
            return null;
        }
        SysUserBO sysUser = sysUserMpManage.getByIdService(Long.valueOf(userId));
        log.info("[wechat-server-monolith][SysUserService][getUserByToken][sysUser={}]", JsonUtil.toJsonString(sysUser));
        return sysUser;
    }
}
