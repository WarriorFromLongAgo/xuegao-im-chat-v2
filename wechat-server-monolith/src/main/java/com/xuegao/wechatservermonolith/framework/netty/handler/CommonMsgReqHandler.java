package com.xuegao.wechatservermonolith.framework.netty.handler;

import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;
import com.xuegao.wechatservermonolith.framework.netty.support.request.CommonMsgReq;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class CommonMsgReqHandler extends SimpleChannelInboundHandler<CommonMsgReq> {
    private static final Logger log = LoggerFactory.getLogger(CommonMsgReqHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                CommonMsgReq msg) {
        log.info("[wechat-server-monolith][CommonMsgReqHandler][channelRead0][msg={}]", JsonUtil.toJsonString(msg));
        Integer messageType = msg.getMessageType();
        MsgSendTypeEnum typeEnum = MsgSendTypeEnum.getEnumByCode(messageType);
        if (MsgSendTypeEnum.containWs(typeEnum)) {
            WsBusinessHandler wsBusinessHandler = new WsBusinessHandler();
            wsBusinessHandler.wsHandler(ctx, msg, typeEnum);
            return;
        }
        System.out.println("CommonMsgReqHandler ===================");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.info("[wechat-server-monolith][CommonMsgReqHandler][channelRegistered][channelRegistered]");

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("[wechat-server-monolith][CommonMsgReqHandler][channelRegistered][channelUnregistered]");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("[wechat-server-monolith][CommonMsgReqHandler][channelRegistered][channelActive]");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("[wechat-server-monolith][CommonMsgReqHandler][channelRegistered][channelInactive]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("[wechat-server-monolith][CommonMsgReqHandler][channelRegistered][channelReadComplete]");
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        log.info("[wechat-server-monolith][CommonMsgReqHandler][channelRegistered][channelWritabilityChanged]");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("[wechat-server-monolith][CommonMsgReqHandler][channelRegistered][exceptionCaught]");
        cause.printStackTrace();
    }
}
