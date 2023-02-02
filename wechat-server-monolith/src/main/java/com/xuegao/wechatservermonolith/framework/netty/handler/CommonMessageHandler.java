package com.xuegao.wechatservermonolith.framework.netty.handler;

import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.framework.netty.support.request.CommonMessage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class CommonMessageHandler extends SimpleChannelInboundHandler<CommonMessage> {
    private static final Logger log = LoggerFactory.getLogger(CommonMessageHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CommonMessage msg) {
        log.info("[wechat-server-monolith][CommonMessageHandler][channelRead0][msg={}]", JsonUtil.toJsonString(msg));
    }
}
