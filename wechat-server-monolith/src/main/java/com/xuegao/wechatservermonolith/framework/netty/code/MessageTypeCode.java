package com.xuegao.wechatservermonolith.framework.netty.code;

import com.alibaba.fastjson2.JSONObject;
import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;
import com.xuegao.wechatservermonolith.framework.netty.support.IMessageType;
import com.xuegao.wechatservermonolith.framework.netty.support.MessageTypeFactory;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageTypeCode {
    private static final Logger log = LoggerFactory.getLogger(MessageTypeCode.class);

    public static final MessageTypeCode INSTANCE = new MessageTypeCode();

    private MessageTypeCode() {
    }

    public IMessageType decode(Object o) {
        if (o instanceof TextWebSocketFrame) {
            TextWebSocketFrame textWebSocketFrame = (TextWebSocketFrame) o;
            String text = textWebSocketFrame.text();
            JSONObject jsonObject = JsonUtil.toClass(text, JSONObject.class);
            if (ObjectUtils.isEmpty(jsonObject)) {
                return MessageTypeFactory.getByMessageType(MsgSendTypeEnum.UNKNOWN.getCode());
            }
            if (jsonObject.containsKey("messageType")) {
                Integer messageType = jsonObject.getInteger("messageType");
                IMessageType messageTypeHandler = MessageTypeFactory.getByMessageType(messageType);
                if (log.isDebugEnabled()) {
                    log.info("[wechat-server-monolith][MessageTypeCode][decode][messageType={}][messageTypeHandler={}]", messageType, JsonUtil.toJsonString(messageTypeHandler));
                }
                if (ObjectUtils.isEmpty(messageTypeHandler)) {
                    return MessageTypeFactory.getByMessageType(MsgSendTypeEnum.UNKNOWN.getCode());
                }
                return messageTypeHandler;
            } else {
                return MessageTypeFactory.getByMessageType(MsgSendTypeEnum.UNKNOWN.getCode());
            }
        }
        if (log.isDebugEnabled()) {
            log.info("[wechat-server-monolith][MessageTypeCode][decode][o={}]", JsonUtil.toJsonString(o));
        }
        // TextWebSocketFrame
        // 前端 websocket 发送信息，怎么可以进行走到这里
        return MessageTypeFactory.getByMessageType(MsgSendTypeEnum.UNKNOWN.getCode());
    }
}
