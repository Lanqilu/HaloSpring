package com.halo.hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Halo
 * @date Created in 2021/10/08 11:07 PM
 * @description 自定义用户页面
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                // 登录页面设置
                .loginPage("/login.html")
                // 登录访问的路径
                .loginProcessingUrl("/user/login")
                // 登录成功之后跳转路径
                .defaultSuccessUrl("/test/index").permitAll()
                // 设置哪些路径可以不用登录直接访问
                .and().authorizeRequests().antMatchers("/", "/test/hello", "/user/login").permitAll()
                .anyRequest().authenticated()
                // 关闭csrf防护
                .and().csrf().disable();
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }


}