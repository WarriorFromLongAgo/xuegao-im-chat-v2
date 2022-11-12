package com.xuegao.wechatservermonolith.sysrole.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.wechatservermonolith.common.model.sysrole.doo.SysRole;
import com.xuegao.wechatservermonolith.sysrole.manage.SysRoleMpManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Service
public class SysRoleService {

    @Autowired
    private SysRoleMpManage sysRoleMpManage;

    public SysRole insertService(SysRole input) {
        sysRoleMpManage.mpInsert(input);
        return input;
    }

    public int updateService(SysRole input) {
        return sysRoleMpManage.mpUpdate(input);
    }

    public int batchDisableService(GenericModelDTO<SysRole> dto) {
        // SysRoleMpManage.mpDisable(dto.getIds());
        return 1;
    }

    public List<SysRole> listService(GenericModelDTO<SysRole> dto) {
        // SysRoleMpManage.mpGetByIds(dto.getIds());
        return Lists.newArrayList();
    }

    public Page<SysRole> searchService(GenericModelDTO<SysRole> dto) {
        // SysRoleMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }
}
