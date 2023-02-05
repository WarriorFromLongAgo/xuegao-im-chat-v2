package com.xuegao.wechatservermonolith.framework.netty.code;

import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.framework.netty.support.IMessageType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageTypeDecoder extends MessageToMessageDecoder<Object> {
    private static final Logger log = LoggerFactory.getLogger(MessageTypeDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, Object msg, List out) {
        IMessageType decode = MessageTypeCode.INSTANCE.decode(msg);
        log.info("[wechat-server-monolith][MessageTypeDecoder][decode][decode={}]", JsonUtil.toJsonString(decode));
        out.add(decode);
    }
}