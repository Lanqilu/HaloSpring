package com.halo.security.distributed.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Halo
 * @create 2021/10/23 下午 06:13
 * @description
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 安全拦截机制（最重要）
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                // .antMatchers("/r/r1").hasAuthority("p2")
                // .antMatchers("/r/r2").hasAuthority("p2")
                // 所有/r/**的请求必须认证通过
                .antMatchers("/r/**").authenticated()
                // 除了/r/**，其它的请求可以访问
                .anyRequest().permitAll()
        ;


    }
}
