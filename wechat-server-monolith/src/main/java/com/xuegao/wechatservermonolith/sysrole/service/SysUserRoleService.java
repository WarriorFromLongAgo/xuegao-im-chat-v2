package com.xuegao.wechatservermonolith.sysrole.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.wechatservermonolith.common.model.sysrole.doo.SysUserRole;
import com.xuegao.wechatservermonolith.sysrole.manage.SysUserRoleMpManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户与权限的关联表 服务实现类
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Service
public class SysUserRoleService {

    @Autowired
    private SysUserRoleMpManage sysUserRoleMpManage;

    public SysUserRole insertService(SysUserRole input) {
        sysUserRoleMpManage.mpInsert(input);
        return input;
    }

    public int updateService(SysUserRole input) {
        return sysUserRoleMpManage.mpUpdate(input);
    }

    public int batchDisableService(GenericModelDTO<SysUserRole> dto) {
        // SysUserRoleMpManage.mpDisable(dto.getIds());
        return 1;
    }

    public List<SysUserRole> listService(GenericModelDTO<SysUserRole> dto) {
        // SysUserRoleMpManage.mpGetByIds(dto.getIds());
        return Lists.newArrayList();
    }

    public Page<SysUserRole> searchService(GenericModelDTO<SysUserRole> dto) {
        // SysUserRoleMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }
}
