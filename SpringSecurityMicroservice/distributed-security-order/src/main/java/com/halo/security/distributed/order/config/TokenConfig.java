package com.halo.security.distributed.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author Halo
 * @create 2021/10/23 下午 03:39
 * @description
 */
@Configuration
public class TokenConfig {

    private final String SIGNING_KEY = "uaa123";

    @Bean
    public TokenStore tokenStore() {
        // JWT 令牌存储方案
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        // 对称秘钥，资源服务器使用该秘钥来验证
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
}