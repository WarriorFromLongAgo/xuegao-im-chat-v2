package com.xuegao.wechatservermonolith.netty.wstempv1;// package com.xuegao.im.netty;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.SpringApplication;
// import org.springframework.context.ConfigurableApplicationContext;
// import org.springframework.stereotype.Component;
//
// import javax.annotation.PreDestroy;
//
// @Component
// public class NettyServer {
//     //
//     @Autowired
//     @Qualifier("serverBootstrap")
//     private ServerBootstrap serverBootstrap;
//
//     private Channel serverChannel;
//
//     public void start() throws Exception {
//         System.out.println("netty启动");
//         serverChannel = serverBootstrap.bind(8888).sync().channel().closeFuture().sync().channel();
//     }
//
//     @PreDestroy
//     public void stop() throws Exception {
//         serverChannel.close();
//         serverChannel.parent().close();
//     }
//     //
//     // ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(XuegaoImDemoApplication.class, args);
//     // NettyServer nettyServer = configurableApplicationContext.getBean(NettyServer.class);
//     //     nettyServer.start();
//
// }
