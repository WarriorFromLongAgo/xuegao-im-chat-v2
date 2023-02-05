package com.xuegao.wechatservermonolith.framework.netty.handler;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;
import com.xuegao.wechatservermonolith.framework.netty.support.request.CommonMsgReq;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WsBusinessHandler {
    private static final Logger log = LoggerFactory.getLogger(WsBusinessHandler.class);

    public void wsHandler(ChannelHandlerContext ctx,
                          CommonMsgReq msg,
                          MsgSendTypeEnum typeEnum) {
        if (MsgSendTypeEnum.WS_OPEN.equals(typeEnum)) {
            wsOpen(ctx, msg);
        } else if (MsgSendTypeEnum.WS_CLOSE.equals(typeEnum)) {
            wsClose(ctx, msg);
        }
    }

    public void wsOpen(ChannelHandlerContext ctx,
                       CommonMsgReq msg) {
        Channel channel = ctx.channel();
        log.info("[wechat-server-monolith][WsBusinessHandler][wsOpen][ip={}]", channel.remoteAddress());
        channel.writeAndFlush(new TextWebSocketFrame(MsgSendTypeEnum.WS_OPEN.getMsg()));
    }

    public void wsClose(ChannelHandlerContext ctx,
                        CommonMsgReq msg) {
        Channel channel = ctx.channel();
        log.info("[wechat-server-monolith][WsBusinessHandler][wsClose][ip={}]", channel.remoteAddress());
        channel.close();
    }

}
