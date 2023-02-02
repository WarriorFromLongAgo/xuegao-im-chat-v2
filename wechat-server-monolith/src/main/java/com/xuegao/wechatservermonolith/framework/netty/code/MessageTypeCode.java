package com.xuegao.wechatservermonolith.framework.netty.code;

import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupMessage;
import com.xuegao.wechatservermonolith.framework.netty.support.IMessageType;
import com.xuegao.wechatservermonolith.framework.netty.support.request.CommonMessage;
import com.xuegao.wechatservermonolith.framework.netty.support.request.HeartBeatPing;

public class MessageTypeCode {
    public static final MessageTypeCode INSTANCE = new MessageTypeCode();

    private MessageTypeCode() {
    }

    public IMessageType decode(Object o) {
        if (o instanceof HeartBeatPing) {
            return (HeartBeatPing) o;
        } else if (o instanceof FriendMessage) {
            return (FriendMessage) o;
        } else if (o instanceof GroupMessage) {
            return (GroupMessage) o;
        } else {
            return (CommonMessage) o;
        }
        // TextWebSocketFrame
        // 前端 websocket 发送信息，怎么可以进行走到这里
    }
}
