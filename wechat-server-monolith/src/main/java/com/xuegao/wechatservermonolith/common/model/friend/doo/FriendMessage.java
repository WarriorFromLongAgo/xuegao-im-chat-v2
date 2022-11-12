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
 * 私聊消息表
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("friend_message")
public class FriendMessage extends GenericModel<Long> implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 发送人id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 接收人id
     */
    @TableField("friend_id")
    private Long friendId;

    /**
     * 消息类型，text，image，audio，video，
     */
    @TableField("message_type")
    private String messageType;

    /**
     * 消息内容
     */
    @TableField("content")
    private String content;

    /**
     * 消息是否送达10已送达，20未送达
     */
    @TableField("ack_type")
    private Integer ackType;

    /**
     * 消息状态，10正常，20撤回
     */
    @TableField("data_status")
    private Integer dataStatus;

}
