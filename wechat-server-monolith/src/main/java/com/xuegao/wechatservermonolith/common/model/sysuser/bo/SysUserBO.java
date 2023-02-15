package com.xuegao.wechatservermonolith.common.model.sysuser.bo;

import com.xuegao.mapper.model.GenericModel;
import com.xuegao.wechatservermonolith.common.model.sysuser.enums.UserStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class SysUserBO extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    private String username;

    /**
     * uuid，用户的唯一标识
     */
    private String uid;

    /**
     * 展示出来的昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 最后登录的年月日
     */
    private LocalDateTime lastLoginTime;

    /**
     * 用户状态,10:正常,20:3个月未登录进行删除锁定,30自主销号
     * {@link UserStatusEnum}
     */
    private Integer userStatus;

    public static SysUserBO buildSysUserBO(Integer userStatus, SysUserBO inputSysUser) {
        SysUserBO sysUserBO = new SysUserBO();
        sysUserBO.setUserStatus(UserStatusEnum.CANCEL.getCode());
        sysUserBO.setLastLoginTime(inputSysUser.getLastLoginTime());
        return sysUserBO;
    }
}
