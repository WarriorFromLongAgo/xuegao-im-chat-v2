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
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import com.xuegao.wechatservermonolith.common.model.sysuser.dto.SysLoginDTO;
import com.xuegao.wechatservermonolith.common.model.sysuser.vo.LoginInfoVO;
import com.xuegao.wechatservermonolith.sysuser.check.SysUserCheckService;
import com.xuegao.wechatservermonolith.sysuser.manage.SysUserMpManage;
import com.xuegao.wechatservermonolith.util.TokenUtil;
import org.apache.commons.lang3.ObjectUtils;
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

        SysUser dbSysUser = sysUserMpManage.getByUsernameOrNickName(sysLoginDTO.getUsername(), sysLoginDTO.getNickname());
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
                            String string1 = JsonUtil.toJsonString(ContextUtil.get());
                            log.info("[xuegao-im-chat-v2][SysUserService][login][context1={}]", string1);
                            ContextUtil.set(context);
                            String string2 = JsonUtil.toJsonString(ContextUtil.get());
                            log.info("[xuegao-im-chat-v2][SysUserService][login][context2={}]", string2);
                            dbSysUser.setLastLoginTime(LocalDateTimeUtil.now());
                            sysUserMpManage.mpUpdate(dbSysUser);
                        },
                        xuegaoSpringTaskExecutor)
                .exceptionally(throwable -> {
                    log.info("[xuegao-im-chat-v2][SysUserService][login apply][exceptionally]", throwable);
                    return null;
                });

        return loginInfoVO;
    }

    public Integer registerService(SysUser sysUser) {
        sysUserCheckService.checkIsNull("入参不能为空", sysUser);
        sysUserCheckService
                .checkIsNull("用户名不能为空", sysUser.getUsername())
                .checkIsNull("昵称不能为空", sysUser.getNickname())
        ;

        SysUser usernameOrNickName = sysUserMpManage.getByUsernameOrNickName(sysUser.getUsername(), sysUser.getNickname());
        try {
            sysUserCheckService.checkIsNotNull("用户名或者昵称已存在", usernameOrNickName);
        } catch (Exception e) {
            log.info("[xuegao-im-chat-v2][SysUserService][registerService][e={}]", e.getMessage(), e);
            throw new ServiceException("用户名或者昵称已存在");
        }
        log.info("[xuegao-im-chat-v2][SysUserService][registerService][1111111111111111111111111111]");
        // 网站不需要填密码
        sysUser.setPassword("123456");

        sysUser.setNickname(sysUser.getUsername());
        sysUser.setUid(UuidUtil.uuid());

        sysUserMpManage.mpInsert(sysUser);
        log.info("[xuegao-im-chat-v2][SysUserService][registerService][sysUser={}]", JsonUtil.toJsonString(sysUser));
        return 1;
    }

    public int updateService(SysUser sysUser) {
        return sysUserMpManage.mpUpdate(sysUser);
    }

    public int batchDisableService(GenericModelDTO<SysUser> dto) {
        // sysUserMpManage.mpDisable(dto.getIds());
        return 1;
    }

    public List<SysUser> listService(GenericModelDTO<SysUser> dto) {
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

    public Page<SysUser> searchService(GenericModelDTO<SysUser> dto) {
        // sysUserMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }

    public SysUser getUserByToken(GenericModelDTO<String> dto) {
        String vo = dto.getVo();
        String userIdByToken = TokenUtil.getUserIdByToken(vo);
        SysUser sysUser = sysUserMpManage.mpGetById(Long.valueOf(userIdByToken));
        log.info("[wechat-server-monolith][SysUserService][getUserByToken][sysUser={}]", JsonUtil.toJsonString(sysUser));

        return sysUser;
    }
}
