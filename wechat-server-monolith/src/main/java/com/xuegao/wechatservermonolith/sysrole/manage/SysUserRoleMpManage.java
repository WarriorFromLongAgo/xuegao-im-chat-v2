package com.xuegao.wechatservermonolith.sysrole.manage;

import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.wechatservermonolith.common.model.sysrole.doo.SysUserRole;
import com.xuegao.wechatservermonolith.sysrole.mapper.SysUserRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleMpManage extends AbstractMpServiceV2<SysUserRoleMapper, SysUserRole, Long> {
    private static final Logger log = LoggerFactory.getLogger(SysUserRoleMpManage.class);


}
