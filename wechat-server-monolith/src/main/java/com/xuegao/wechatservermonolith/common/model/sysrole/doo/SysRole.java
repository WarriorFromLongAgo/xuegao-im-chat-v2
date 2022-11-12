package com.xuegao.wechatservermonolith.common.model.sysrole.doo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xuegao.mapper.model.GenericModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("sys_role")
public class SysRole extends GenericModel<Integer> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 默认是0，最大的管理员是999999
     */
    @TableField("role_type")
    private Integer roleType;

    /**
     * 权限说明，999999，最大的管理员，0，普通用户
     */
    @TableField("role_remark")
    private String roleRemark;


}
