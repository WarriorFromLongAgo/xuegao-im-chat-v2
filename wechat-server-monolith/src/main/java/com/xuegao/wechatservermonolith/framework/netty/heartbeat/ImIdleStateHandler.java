package com.xuegao.wechatservermonolith.framework.netty.heartbeat;

import com.xuegao.wechatservermonolith.framework.netty.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ImIdleStateHandler extends IdleStateHandler {
    private static final Logger log = LoggerFactory.getLogger(ImIdleStateHandler.class);

    private static final int READER_IDLE_TIME = 90;

    private ImIdleStateHandler() {
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    public ImIdleStateHandler(long readerIdleTime, long writerIdleTime, long allIdleTime) {
        super(readerIdleTime, writerIdleTime, allIdleTime, TimeUnit.SECONDS);
    }

    public ImIdleStateHandler(long readerIdleTime, long writerIdleTime, long allIdleTime, TimeUnit unit) {
        super(readerIdleTime, writerIdleTime, allIdleTime, unit);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) {
        log.info(READER_IDLE_TIME + "秒内未读到数据，关闭连接");
        SessionUtil.unbindSession(ctx.channel());
        ctx.channel().close();
    }
}
