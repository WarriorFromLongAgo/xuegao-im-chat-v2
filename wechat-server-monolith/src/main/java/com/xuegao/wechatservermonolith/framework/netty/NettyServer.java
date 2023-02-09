package com.xuegao.wechatservermonolith.framework.netty;

import com.xuegao.wechatservermonolith.framework.netty.code.MessageTypeDecoder;
import com.xuegao.wechatservermonolith.framework.netty.handler.*;
import com.xuegao.wechatservermonolith.framework.netty.heartbeat.ImIdleStateHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/6/4 16:10
 */
@Configuration
@Component
public class NettyServer {
    private static final Logger log = LoggerFactory.getLogger(NettyServer.class);
    private final LoggingHandler loggingHandler = new LoggingHandler(LogLevel.INFO);

    private Channel serverChannel;

    private NioEventLoopGroup bossGroup;

    private NioEventLoopGroup workerGroup;

    @Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        // bossGroup设置1个，参考NG。 在不 bind 多端口的情况下 BossEventLoopGroup 中只需要包含一个 EventLoop，也只能用上一个，多了没用。
        bossGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("[bossGroup]"));
        return bossGroup;
    }

    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        int cpuCount = Runtime.getRuntime().availableProcessors();
        workerGroup = new NioEventLoopGroup(cpuCount << 1 + 1, new DefaultThreadFactory("[workerGroup]"));
        return workerGroup;
    }

    @Bean(name = "serverBootstrap")
    public ServerBootstrap bootstrap() {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 设置两个 EventLoopGroup 对象
        serverBootstrap.group(bossGroup(), workerGroup())
                // 指定 Channel 为服务端 NioServerSocketChannel
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        // WebSocket基于HTTP协议进行连接
                        pipeline.addLast(new HttpServerCodec());
                        // 对写大数据提供支持
                        pipeline.addLast(new ChunkedWriteHandler());
                        pipeline.addLast(new HttpObjectAggregator(1024 * 64));
                        // pipeline.addLast(loggingHandler);

                        // 第一种 websocket 方法
                        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
                        // 第二种 websocket 方法
                        // pipeline.addLast(new WSServerHandler());

                        // 使用了MessageTypeDecoder后，就只能使用这个了
                        pipeline.addLast(new ImIdleStateHandler(180, 0, 0));
                        // 如果没使用，那么可以随便控制
                        // pipeline.addLast(new IdleStateHandler(0, 0, 60));
                        // pipeline.addLast(new HeartBeatHandler());

                        // 根据消息类型，决定走什么数据
                        pipeline.addLast(new MessageTypeDecoder());

                        // 根据 msgType 解析出对应的 handler
                        pipeline.addLast(new HeartBeatPingHandler());
                        pipeline.addLast(new FriendMsgReqHandler());
                        pipeline.addLast(new GroupMsgReqHandler());
                        pipeline.addLast(new SysUserMsgReqHandler());

                        // CommonMsgReqHandler 由于是所有人的父类，得放在下面
                        pipeline.addLast(new CommonMsgReqHandler());
                        // 根据 msgType 解析出对应的 handler

                        pipeline.addLast(new ExceptionHandler());

                    }
                })
                // 服务端 accept 队列的大小
                // 给服务器端连接请求队列中队列的大小,达到上限则不进行新的tcp连接
                .option(ChannelOption.SO_BACKLOG, 1024)
                // TCP Keepalive 机制，实现 TCP 层级的心跳保活功能
                // 客户端连接是否长连接
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                // 允许较小的数据包的发送，降低延迟
                .childOption(ChannelOption.TCP_NODELAY, true)
                // 客户端连接开启Nagle算法，true表示关闭，false表示开启   高实时性就关闭，否则开启
                .childOption(ChannelOption.TCP_NODELAY, true)

                .handler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel ch) {
                        log.info("[wechat-server-monolith][NettyServer][initChannel][服务启动中]");
                    }
                })
        ;
        return serverBootstrap;
    }

    public synchronized void start(int port) throws Exception {
        log.info("[xuegao-im-chat-2022][NettyServer][start][serverChannel.port={}]", port);
        serverChannel = bootstrap().bind(port)
                .sync()
                .channel();
        log.info("[xuegao-im-chat-2022][NettyServer][start完成]");
    }

    public synchronized void stop() {
        log.info("[xuegao-im-chat-2022][NettyServer][stop]");
        if (Objects.nonNull(serverChannel)) {
            serverChannel.close();
            log.info("[xuegao-im-chat-2022][NettyServer][stop][serverChannel.close()]");
        }
        if (Objects.nonNull(serverChannel) && Objects.nonNull(serverChannel.parent())) {
            serverChannel.parent().close();
            log.info("[xuegao-im-chat-2022][NettyServer][stop][serverChannel.parent().close()]");
        }
        // 优雅关闭两个 EventLoopGroup 对象
        if (Objects.nonNull(bossGroup)) {
            bossGroup.shutdownGracefully();
            log.info("[xuegao-im-chat-2022][NettyServer][stop][bossGroup.shutdownGracefully()]");
        }
        if (Objects.nonNull(workerGroup)) {
            workerGroup.shutdownGracefully();
            log.info("[xuegao-im-chat-2022][NettyServer][stop][workerGroup.shutdownGracefully()]");
        }
        log.info("[xuegao-im-chat-2022][NettyServer][stop完成]");
    }

}