package com.xuegao.wechatservermonolith.common.model.sysuser.bo;

import com.xuegao.mapper.model.GenericModel;
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
}
