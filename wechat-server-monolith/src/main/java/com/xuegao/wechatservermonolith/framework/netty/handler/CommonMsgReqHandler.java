package com.xuegao.wechatservermonolith.framework.netty.handler;

import com.xuegao.util.JsonUtil;
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
    protected void channelRead0(ChannelHandlerContext ctx, CommonMsgReq msg) {
        log.info("[wechat-server-monolith][CommonMsgReqHandler][channelRead0][msg={}]", JsonUtil.toJsonString(msg));
    }
}
