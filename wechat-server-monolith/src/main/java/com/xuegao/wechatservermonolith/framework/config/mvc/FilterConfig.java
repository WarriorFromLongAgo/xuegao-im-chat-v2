package com.xuegao.wechatservermonolith.framework.config.mvc;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean testFirstFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TestFirstFilter());
        registration.addUrlPatterns("/*");
        // registration.setName("testFirstFilter");
        // registration.setOrder(-1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean testLastFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TestLastFilter());
        registration.addUrlPatterns("/*");
        // registration.setName("testLastFilter");
        // registration.setOrder(1);
        return registration;
    }


}