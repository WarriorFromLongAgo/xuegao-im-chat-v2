package com.xuegao.wechatservermonolith.common.model.sysrole.doo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xuegao.mapper.model.GenericModel;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户与权限的关联表
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("sys_user_role")
public class SysUserRole extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * xue_gao_user的主键id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * sys_role
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 操作说明
     */
    @TableField("operate_remark")
    private String operateRemark;


}
