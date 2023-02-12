package com.xuegao.wechatservermonolith.common.model.sysuser.convert;

import com.xuegao.wechatservermonolith.common.model.sysuser.bo.SysUserBO;
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;

public class SysUserConvert {

    public static SysUserBO toSysUserBO(SysUser sysUser) {
        SysUserBO sysUserBO = new SysUserBO();
        sysUserBO.setUsername(sysUser.getUsername());
        sysUserBO.setUid(sysUser.getUid());
        sysUserBO.setNickname(sysUser.getNickname());
        sysUserBO.setAvatar(sysUser.getAvatar());

        sysUserBO.setId(sysUser.getId());
        sysUserBO.setCreatedBy(sysUser.getCreatedBy());
        sysUserBO.setCreatedTime(sysUser.getCreatedTime());
        sysUserBO.setUpdatedBy(sysUser.getUpdatedBy());
        sysUserBO.setUpdatedTime(sysUser.getUpdatedTime());
        return sysUserBO;
    }

}
