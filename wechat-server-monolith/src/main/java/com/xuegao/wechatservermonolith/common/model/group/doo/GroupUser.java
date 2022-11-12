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
@TableName("group_user")
public class GroupUser extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 群展示昵称
     */
    @TableField("user_nickname")
    private String userNickname;

    /**
     * 群id
     */
    @TableField("group_id")
    private Long groupId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;


}
