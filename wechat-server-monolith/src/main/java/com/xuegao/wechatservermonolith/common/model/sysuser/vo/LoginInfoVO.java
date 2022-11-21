package com.xuegao.wechatservermonolith.common.model.sysuser.vo;

import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 *
 */
@Getter
@Setter
public class LoginInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户本次登录的时候 用户ip
     */
    private String userIp;
    /**
     * 用户本次登录的时候 省份
     */
    private String userProvince;
    /**
     * 用户本次登录的时候 城市
     */
    private String userCity;
    /**
     * 用户本次登录的时候 城市区号
     */
    private String userCityCode;
    /**
     * 用户本次登录的 token
     */
    private String token;
    /**
     * 本次登录的用户
     */
    private SysUser sysUser;

}
