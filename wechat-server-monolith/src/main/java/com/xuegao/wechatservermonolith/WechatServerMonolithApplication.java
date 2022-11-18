package com.xuegao.wechatservermonolith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WechatServerMonolithApplication {
    private static final Logger log = LoggerFactory.getLogger(WechatServerMonolithApplication.class);


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WechatServerMonolithApplication.class);
        application.run(args);
        log.info("[xuegao-im-chat-v2][WechatServerMonolithApplication][main][]");
    }

}
