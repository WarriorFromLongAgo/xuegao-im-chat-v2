package com.xuegao.wechatservermonolith.framework.netty.code;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class MessageTypeDecoder extends MessageToMessageDecoder<Object> {

    @Override
    protected void decode(ChannelHandlerContext ctx, Object msg, List out) {
        out.add(MessageTypeCode.INSTANCE.decode(msg));
    }
}