package com.halo.security.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author Halo
 * @create 2021/10/23 下午 03:39
 * @description
 */
@Configuration
public class TokenConfig {
    /**
     * 令牌存储策略
     *
     * @return 生成普通令牌（相对于 JWT 令牌）
     */
    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
}