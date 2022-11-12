package com.xuegao.wechatservermonolith.sysuser.manage;

import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import com.xuegao.wechatservermonolith.sysuser.mapper.SysUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SysUserMpManage extends AbstractMpServiceV2<SysUserMapper, SysUser, Long> {
    private static final Logger log = LoggerFactory.getLogger(SysUserMpManage.class);


}
