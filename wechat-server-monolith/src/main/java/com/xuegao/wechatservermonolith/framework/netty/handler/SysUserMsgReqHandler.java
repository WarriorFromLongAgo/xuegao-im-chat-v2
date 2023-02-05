package com.xuegao.wechatservermonolith.framework.netty.handler;

import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import com.xuegao.wechatservermonolith.framework.netty.support.request.SysUserMsgReq;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class SysUserMsgReqHandler extends SimpleChannelInboundHandler<SysUserMsgReq> {
    private static final Logger log = LoggerFactory.getLogger(SysUserMsgReqHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SysUserMsgReq msg) {
        log.info("[wechat-server-monolith][SysUserMsgReqHandler][channelRead0][msg={}]", JsonUtil.toJsonString(msg));
        String content = msg.getContent();
        SysUser inputSysUser = JsonUtil.toClass(content, SysUser.class);



    }
}
