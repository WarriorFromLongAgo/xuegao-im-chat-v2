package com.xuegao.wechatservermonolith.framework.config.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final Logger log = LoggerFactory.getLogger(WebConfig.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry
        //         .addInterceptor(new FmkLogInterceptor())
        //         .excludePathPatterns("/sysUser/login")
        //         .excludePathPatterns("/sysUser/register")
        //         .addPathPatterns("/**");
        // registry
        //         .addInterceptor(new CrossInterceptor())
        //         .addPathPatterns("/**");
        registry
                .addInterceptor(new TokenInterceptor())
                .excludePathPatterns("/sysUser/login")
                .excludePathPatterns("/sysUser/register")
                // .excludePathPatterns("/sysUser/getUserByToken")
                // .excludePathPatterns("/sysUser/list")
                .addPathPatterns("/**");
        registry
                .addInterceptor(new DiyHeaderInterceptor())
                .excludePathPatterns("/sysUser/login")
                .excludePathPatterns("/sysUser/register")
                .excludePathPatterns("/sysUser/getUserByToken")
                .addPathPatterns("/**");
        // registry
        //         .addInterceptor(new TestFirstInterceptor())
        //         .excludePathPatterns("/sysUser/login")
        //         .excludePathPatterns("/sysUser/register")
        //         .addPathPatterns("/**");
        // registry
        //         .addInterceptor(new TestLastInterceptor())
        //         .excludePathPatterns("/sysUser/login")
        //         .excludePathPatterns("/sysUser/register")
        //         .addPathPatterns("/**");
    }
}