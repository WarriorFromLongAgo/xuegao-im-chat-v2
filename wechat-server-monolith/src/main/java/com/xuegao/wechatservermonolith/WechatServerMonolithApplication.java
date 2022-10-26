package com.xuegao.wechatservermonolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WechatServerMonolithApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WechatServerMonolithApplication.class);
        application.run(args);
    }

}
