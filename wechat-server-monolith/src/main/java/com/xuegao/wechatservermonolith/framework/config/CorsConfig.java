package com.xuegao.wechatservermonolith.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/6/1 18:06
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        设置允许跨域的路径
        registry.addMapping("/**")
//                设置允许跨域请求的域名
                .allowedOrigins("*")
//                是否允许证书
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("*")
//                跨域允许时间
                .maxAge(3600);
    }
}
