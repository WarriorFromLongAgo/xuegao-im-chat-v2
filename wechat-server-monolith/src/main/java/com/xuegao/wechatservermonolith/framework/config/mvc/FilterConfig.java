package com.xuegao.wechatservermonolith.framework.config.mvc;

import com.xuegao.log.web.filter.FmkLogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<FmkLogFilter> testFmkLogFilter() {
        FilterRegistrationBean<FmkLogFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new FmkLogFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean<TestFirstFilter> testFirstFilter() {
        FilterRegistrationBean<TestFirstFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new TestFirstFilter());
        registration.addUrlPatterns("/*");
        // registration.setName("testFirstFilter");
        // registration.setOrder(-1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean<TestLastFilter> testLastFilter() {
        FilterRegistrationBean<TestLastFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new TestLastFilter());
        registration.addUrlPatterns("/*");
        // registration.setName("testLastFilter");
        // registration.setOrder(1);
        return registration;
    }


}