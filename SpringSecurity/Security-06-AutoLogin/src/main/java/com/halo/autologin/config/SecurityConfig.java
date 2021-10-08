package com.halo.autologin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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

    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                // 登录页面设置
                .loginPage("/login.html")
                // 登录访问的路径
                .loginProcessingUrl("/user/login")
                // 登录成功之后跳转路径
                .defaultSuccessUrl("/success.html").permitAll()
                // 设置哪些路径可以不用登录直接访问
                .and().authorizeRequests().antMatchers("/", "/test/hello", "/user/login").permitAll()
                // 当前登录用户只有admins权限才可以访问这个路径
                .antMatchers("/test/index").hasAuthority("admins")
                .anyRequest().authenticated()
                // 1. 开启记住我
                .and().rememberMe().tokenRepository(persistentTokenRepository())
                // 2. 设置有效时时长 单位秒
                .tokenValiditySeconds(60)
                // 3. 设置查询数据库的Service
                .userDetailsService(userDetailsService)
                // 关闭csrf防护
                .and().csrf().disable();
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }


}