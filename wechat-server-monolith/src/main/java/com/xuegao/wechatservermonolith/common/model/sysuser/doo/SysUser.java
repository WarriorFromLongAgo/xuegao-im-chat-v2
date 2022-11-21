package com.xuegao.wechatservermonolith.common.model.sysuser.doo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xuegao.mapper.model.GenericModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("xue_gao_user")
public class SysUser extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * uuid，用户的唯一标识
     */
    @TableField("uid")
    private String uid;

    /**
     * 展示出来的昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 性别,1男，2女，3其他
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 手机号码
     */
    @TableField("mobile_phone")
    private String mobilePhone;

    /**
     * 固定电话
     */
    @TableField("landline_phone")
    private String landlinePhone;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 最后登录的年月日
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    /**
     * 用户状态,10:正常,20:3个月未登录进行删除锁定,30自主销号
     */
    @TableField("user_status")
    private Integer userStatus;

    /**
     * 用户注册的时候 用户ip
     */
    @TableField(exist = false)
    private String userIp;
    /**
     * 用户注册的时候 省份
     */
    @TableField(exist = false)
    private String userProvince;
    /**
     * 用户注册的时候 城市
     */
    @TableField(exist = false)
    private String userCity;
    /**
     * 用户注册的时候 城市区号
     */
    @TableField(exist = false)
    private String userCityCode;
    /**
     * 签名
     */
    @TableField(exist = false)
    private String signature;
}
