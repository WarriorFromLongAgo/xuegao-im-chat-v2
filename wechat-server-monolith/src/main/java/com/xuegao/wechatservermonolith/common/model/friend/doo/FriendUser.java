package com.xuegao.wechatservermonolith.common.model.friend.doo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xuegao.mapper.model.GenericModel;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户与朋友关系
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("friend_user")
public class FriendUser extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * user_id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 朋友的user_id
     */
    @TableField("friend_id")
    private Long friendId;

}
