package com.xuegao.wechatservermonolith.framework.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry
        //         .addInterceptor(new FmkLogInterceptor())
        //         .excludePathPatterns("/sysUser/login")
        //         .excludePathPatterns("/sysUser/register")
        //         .addPathPatterns("/**");
        registry
                .addInterceptor(new TokenInterceptor())
                .excludePathPatterns("/sysUser/login")
                .excludePathPatterns("/sysUser/register")
                .excludePathPatterns("/sysUser/list")
                .addPathPatterns("/**");
        registry
                .addInterceptor(new TestFirstInterceptor())
                .excludePathPatterns("/sysUser/login")
                .excludePathPatterns("/sysUser/register")
                .addPathPatterns("/**");
        registry
                .addInterceptor(new TestLastInterceptor())
                .excludePathPatterns("/sysUser/login")
                .excludePathPatterns("/sysUser/register")
                .addPathPatterns("/**");
    }
}