package com.xuegao.wechatservermonolith.netty.ws2;// package com.xuegao.im.netty.ws2;
//
// import com.xuegao.im.netty.ws.TextWebSocketFrameServerHandler;
// import io.netty.channel.ChannelHandler;
// import io.netty.channel.ChannelInitializer;
// import io.netty.channel.ChannelPipeline;
// import io.netty.channel.socket.SocketChannel;
// import io.netty.handler.codec.http.HttpObjectAggregator;
// import io.netty.handler.codec.http.HttpServerCodec;
//
// @ChannelHandler.Sharable
// public class WsChannelInitializer2 extends ChannelInitializer<SocketChannel> {
//
//     @Override
//     protected void initChannel(SocketChannel ch) {
//         ChannelPipeline pipeline = ch.pipeline();
//         // websocket是基于http协议的，所以需要使用http编解码器
//         pipeline.addLast(new HttpServerCodec());
//
//         // 对http消息的聚合，聚合成FullHttpRequest或FullHttpResponse
//         // 在Netty的编程中，几乎都会使用到这个handler
//         pipeline.addLast(new HttpObjectAggregator(1024 * 64));
//
//         pipeline.addLast(new WSServerHandler());
//     }
// }
//
