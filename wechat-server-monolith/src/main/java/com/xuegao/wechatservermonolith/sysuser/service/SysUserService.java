package com.xuegao.wechatservermonolith.sysuser.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import com.xuegao.wechatservermonolith.sysuser.manage.SysUserMpManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    private SysUserMpManage sysUserMpManage;

    public SysUser insertService(SysUser sysUser) {
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
