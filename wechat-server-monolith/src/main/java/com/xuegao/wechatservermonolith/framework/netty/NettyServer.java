package com.xuegao.wechatservermonolith.framework.netty;

import com.xuegao.wechatservermonolith.framework.netty.ws.TextWsFrameHandler;
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
import io.netty.handler.stream.ChunkedWriteHandler;
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

    private Channel serverChannel;

    private NioEventLoopGroup bossGroup;

    private NioEventLoopGroup workerGroup;

    @Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        return bossGroup = new NioEventLoopGroup();
    }

    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        return workerGroup = new NioEventLoopGroup();
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
                        pipeline.addLast(new HttpServerCodec());
                        pipeline.addLast(new ChunkedWriteHandler());
                        pipeline.addLast(new HttpObjectAggregator(65536));
                        // 第一种 websocket 方法
                        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
                        pipeline.addLast(new TextWsFrameHandler());

                        // 第二种 websocket 方法
                        // pipeline.addLast(new WSServerHandler());
                    }
                })
                // 服务端 accept 队列的大小
                .option(ChannelOption.SO_BACKLOG, 1024)
                // TCP Keepalive 机制，实现 TCP 层级的心跳保活功能
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                // 允许较小的数据包的发送，降低延迟
                .childOption(ChannelOption.TCP_NODELAY, true);
        ;
        return serverBootstrap;
    }

    public void start(int port) throws Exception {
        log.info("[xuegao-im-chat-2022][NettyServer][start][serverChannel.port={}]", port);
        serverChannel = bootstrap().bind(port)
                .sync()
                .channel();
        log.info("[xuegao-im-chat-2022][NettyServer][start完成]");
    }

    public void stop() {
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