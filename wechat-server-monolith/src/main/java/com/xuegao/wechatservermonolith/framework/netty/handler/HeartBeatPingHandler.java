package com.xuegao.wechatservermonolith.framework.netty.handler;

import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.framework.netty.support.request.HeartBeatPingMsgReq;
import com.xuegao.wechatservermonolith.framework.netty.support.response.HeartBeatPongResp;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@ChannelHandler.Sharable
@Component
public class HeartBeatPingHandler extends SimpleChannelInboundHandler<HeartBeatPingMsgReq> {
    private static final Logger log = LoggerFactory.getLogger(HeartBeatPingHandler.class);
    private int readTimeOutCount = 0;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                HeartBeatPingMsgReq msg) {
        log.info("[wechat-server-monolith][HeartBeatPingHandler][channelRead0][msg={}]", JsonUtil.toJsonString(msg));
        ctx.channel().writeAndFlush(new TextWebSocketFrame(JsonUtil.toJsonString(HeartBeatPongResp.buildPongByPing())));
    }

    // 如果同时有 channelRead0 和 channelRead，会先触发 channelRead0
    // @Override
    // public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    //     log.info("[wechat-server-monolith][HeartBeatPingHandler][channelRead][msg={}]", msg);
    // }

    // @Override
    // public void channelActive(ChannelHandlerContext ctx) throws Exception {
    //     log.info("[wechat-server-monolith][HeartBeatPingHandler][channelActive][channelActive]");
    // }

}
