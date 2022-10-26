package com.xuegao.wechatservermonolith.netty.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/6/4 16:19
 */
@Component
public class ServerStartListener12 implements ApplicationRunner, Ordered {
    @Override
    public void run(ApplicationArguments args) {
        System.out.println(getClass().getName() + "=============" + getOrder());
    }

    @Override
    public int getOrder() {
        return 12;
    }
}