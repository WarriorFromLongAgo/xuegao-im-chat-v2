package com.xuegao.wechatservermonolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.xuegao.wechatservermonolith"})
public class WechatServerMonolithApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WechatServerMonolithApplication.class);
        application.run(args);
    }

}
