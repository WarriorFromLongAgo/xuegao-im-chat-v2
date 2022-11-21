package com.xuegao.wechatservermonolith.common.model.friend.doo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xuegao.mapper.model.GenericModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
    /**
     * 免打扰
     */
    @TableField(exist = false)
    private Integer notDisturb;
    /**
     * 好友备注
     */
    @TableField(exist = false)
    private String friendNote;
    /**
     * friendSource
     * <p>
     * uid搜索
     * 昵称搜索
     * 手机号码搜索
     * 邮箱搜索
     */
    @TableField(exist = false)
    private String friendSource;
}
