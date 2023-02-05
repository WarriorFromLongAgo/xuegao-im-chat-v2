package com.xuegao.wechatservermonolith.framework.netty.code;

import com.alibaba.fastjson2.JSONObject;
import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;
import com.xuegao.wechatservermonolith.framework.netty.support.IMessageType;
import com.xuegao.wechatservermonolith.framework.netty.support.request.*;
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
                return CommonMsgReq.buildMsgReqByReq(text);
            }
            if (!jsonObject.containsKey("messageType")) {
                return CommonMsgReq.buildMsgReqByReq(text);
            }
            Integer messageType = jsonObject.getInteger("messageType");
            MsgSendTypeEnum sendTypeEnum = MsgSendTypeEnum.getEnumByCode(messageType);
            if (log.isDebugEnabled()) {
                log.info("[wechat-server-monolith][MessageTypeCode][decode][jsonObject={}]", jsonObject);
            }
            if (MsgSendTypeEnum.containWs(sendTypeEnum)) {
                return CommonMsgReq.buildMsgReqByReq(sendTypeEnum, text);
            } else if (MsgSendTypeEnum.HEART_BEAT_PING.equals(sendTypeEnum)) {
                return HeartBeatPingMsgReq.buildMsgReqByReq(text);
            } else if (MsgSendTypeEnum.ONE_TO_ONE.equals(sendTypeEnum)) {
                return FriendMsgReq.buildMsgReqByReq(text);
            } else if (MsgSendTypeEnum.MANY_TO_MANY.equals(sendTypeEnum)) {
                return GroupMsgReq.buildMsgReqByReq(text);
            } else if (MsgSendTypeEnum.BING_SESSION.equals(sendTypeEnum)) {
                return SysUserMsgReq.buildMsgReqByReq(text);
            } else {
                return CommonMsgReq.buildMsgReqByReq(text);
            }
        }
        log.info("[wechat-server-monolith][MessageTypeCode][decode][o={}]", JsonUtil.toJsonString(o));
        // TextWebSocketFrame
        // 前端 websocket 发送信息，怎么可以进行走到这里
        return null;
    }
}
