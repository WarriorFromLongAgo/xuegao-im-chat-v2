package com.xuegao.wechatservermonolith.framework.netty;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/6/4 16:36
 */
@Component
public class NettyStartStopListener implements DisposableBean, CommandLineRunner {

    @Value("${netty.port:61013}")
    private int nettyPort;

    @Autowired
    private NettyServer nettyServer;

    @Override
    public void destroy() {
        nettyServer.stop();
    }

    @Override
    public void run(String... args) throws Exception {
        nettyServer.start(nettyPort);
    }
}