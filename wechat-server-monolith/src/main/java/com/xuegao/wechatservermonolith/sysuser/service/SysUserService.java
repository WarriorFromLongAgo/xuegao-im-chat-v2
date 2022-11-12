package com.xuegao.wechatservermonolith.sysuser.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.core.common.FmkConstant;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.util.LocalDateTimeUtil;
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import com.xuegao.wechatservermonolith.common.model.sysuser.vo.SysLoginVO;
import com.xuegao.wechatservermonolith.sysuser.check.SysUserCheckService;
import com.xuegao.wechatservermonolith.sysuser.manage.SysUserMpManage;
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

    public SysLoginVO login(SysUser sysUser) {
        sysUserCheckService.checkIsNull("入参不能为空", sysUser);
        sysUserCheckService
                .checkIsNull("用户名不能为空", sysUser.getUsername())
                .checkIsNull("密码不能为空", sysUser.getPassword());
        SysUser byUsernameAndPassword = sysUserMpManage.getByUsernameAndPassword(sysUser.getUsername(), sysUser.getPassword());
        if (ObjectUtils.isEmpty(byUsernameAndPassword)) {
            return null;
        }
        String token = UUID.randomUUID().toString();
        SysLoginVO sysLoginVO = new SysLoginVO();
        sysLoginVO.setToken(token);
        sysLoginVO.setSysUser(byUsernameAndPassword);

        CompletableFuture
                .runAsync(() -> {
                            byUsernameAndPassword.setLastLoginTime(LocalDateTimeUtil.now());
                            sysUserMpManage.mpUpdate(byUsernameAndPassword);
                        },
                        xuegaoSpringTaskExecutor)
                .exceptionally(throwable -> {
                    log.info("[xuegao-im-chat-v2][SysUserService][login apply][exceptionally]", throwable);
                    return null;
                });

        return sysLoginVO;
    }

    public SysUser insertService(SysUser sysUser) {
        sysUserCheckService.checkIsNull("入参不能为空", sysUser);
        sysUserCheckService
                .checkIsNull("用户名不能为空", sysUser.getUsername());

        // 网站不需要填密码
        sysUser.setPassword("123456");

        sysUser.setNickname(sysUser.getUsername());
        sysUser.setUid(UUID.randomUUID().toString());

        sysUserMpManage.mpInsert(sysUser);
        return sysUser;
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
        return Lists.newArrayList();
    }

    public Page<SysUser> searchService(GenericModelDTO<SysUser> dto) {
        // sysUserMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }
}
