package com.xuegao.wechatservermonolith.framework.netty.handler;

import com.xuegao.util.JsonUtil;
import com.xuegao.util.SpringUtil;
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import com.xuegao.wechatservermonolith.framework.netty.support.request.SysUserMsgReq;
import com.xuegao.wechatservermonolith.util.WsSessionUtil;
import com.xuegao.wechatservermonolith.sysuser.manage.SysUserMpManage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ChannelHandler.Sharable
@Component
public class SysUserMsgReqHandler extends SimpleChannelInboundHandler<SysUserMsgReq> {
    private static final Logger log = LoggerFactory.getLogger(SysUserMsgReqHandler.class);

    @Autowired
    private SysUserMpManage sysUserMpManage;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SysUserMsgReq msg) {
        log.info("[wechat-server-monolith][SysUserMsgReqHandler][channelRead0][msg={}]", JsonUtil.toJsonString(msg));
        String content = msg.getContent();
        SysUser inputSysUser = JsonUtil.toClass(content, SysUser.class);
        SysUserMpManage mpManage = SpringUtil.getBean(SysUserMpManage.class);
        SysUser sysUser = mpManage.mpGetById(inputSysUser.getId());
        // SysUser sysUser = sysUserMpManage.mpGetById(inputSysUser.getId());
        log.info("[wechat-server-monolith][SysUserMsgReqHandler][channelRead0][sysUser={}]", JsonUtil.toJsonString(sysUser));
        WsSessionUtil.bindSession(sysUser, ctx.channel());
    }
}
