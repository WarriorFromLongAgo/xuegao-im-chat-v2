// package com.xuegao.wechatservermonolith.common.model.common;
//
// import com.baomidou.mybatisplus.annotation.TableField;
// import lombok.Getter;
// import lombok.Setter;
// import lombok.experimental.Accessors;
//
// import java.io.Serializable;
//
// 由于Java只能单继承
//
// @Getter
// @Setter
// @Accessors(chain = true)
// public class Message implements Serializable {
//     private static final long serialVersionUID = 1L;
//
//     /**
//      * 消息类型，text，image，audio，video，
//      */
//     @TableField("message_type")
//     String messageType;
//
//     /**
//      * 消息内容
//      */
//     @TableField("content")
//     private String content;
//
//     /**
//      * 消息是否送达10已送达，20未送达
//      */
//     @TableField("ack_type")
//     private Integer ackType;
//
//     /**
//      * 消息状态，10正常，20撤回
//      */
//     @TableField("data_status")
//     private Integer dataStatus;
// }
