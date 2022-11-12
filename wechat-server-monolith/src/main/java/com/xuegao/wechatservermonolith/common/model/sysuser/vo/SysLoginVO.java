package com.xuegao.wechatservermonolith.common.model.sysuser.vo;

import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SysLoginVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private SysUser sysUser;

    private String token;

}
