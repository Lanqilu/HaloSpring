package com.halo.config;

import com.halo.filter.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Halo
 * @create 2021/11/12 下午 04:32
 * @description
 */
@Configuration
public class AntiSamyConfiguration {
    /**
     * 配置跨站攻击过滤器
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean(new XssFilter());
        // 过滤的地址
        filterRegistration.addUrlPatterns("/*");
        // 设置过滤器顺序
        filterRegistration.setOrder(1);

        return filterRegistration;
    }
}