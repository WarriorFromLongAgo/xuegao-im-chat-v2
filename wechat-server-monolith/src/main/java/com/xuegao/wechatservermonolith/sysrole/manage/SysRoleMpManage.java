package com.xuegao.wechatservermonolith.sysrole.manage;

import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.wechatservermonolith.common.model.sysrole.doo.SysRole;
import com.xuegao.wechatservermonolith.sysrole.mapper.SysRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SysRoleMpManage extends AbstractMpServiceV2<SysRoleMapper, SysRole, Integer> {
    private static final Logger log = LoggerFactory.getLogger(SysRoleMpManage.class);


}
