package com.pedro.ratelimiter.starter.autoconfigure;

import com.pedro.ratelimiter.MemoryRateLimiter;
import com.pedro.ratelimiter.RateLimiter;
import com.pedro.ratelimiter.RedisRateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PlimitProperties.class)
public class PlimitAutoConfiguration {

    @Autowired
    private PlimitProperties plimitProperties;

    @Bean
    public RateLimiter rateLimiter() {
        switch (plimitProperties.getLimitStrategy()) {
            case "memory":
                return new MemoryRateLimiter();
            case "redis":
                return new RedisRateLimiter();
            default:
                return new MemoryRateLimiter();
        }
    }
}
