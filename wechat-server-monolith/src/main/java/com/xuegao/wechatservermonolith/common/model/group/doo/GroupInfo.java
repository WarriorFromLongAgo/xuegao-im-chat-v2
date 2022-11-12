package com.xuegao.wechatservermonolith.common.model.group.doo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xuegao.mapper.model.GenericModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 群组信息
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("group_info")
public class GroupInfo extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 群名字
     */
    @TableField("name")
    private String name;

    /**
     * 群介绍
     */
    @TableField("description")
    private String description;

    /**
     * 群主的user_id
     */
    @TableField("owner_id")
    private Long ownerId;


}
