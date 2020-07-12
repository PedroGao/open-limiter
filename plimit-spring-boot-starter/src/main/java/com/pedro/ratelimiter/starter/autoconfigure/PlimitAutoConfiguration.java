package com.pedro.ratelimiter.starter.autoconfigure;

import com.pedro.ratelimiter.MemoryRateLimiter;
import com.pedro.ratelimiter.RateLimiter;
import com.pedro.ratelimiter.RedisRateLimiter;
import com.pedro.ratelimiter.rule.RuleConfig;
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
        RuleConfig ruleConfig = plimitProperties.getRuleConfig();
        switch (plimitProperties.getStorage()) {
            case "redis":
                if (ruleConfig == null) {
                    return new RedisRateLimiter();
                }
                return new RedisRateLimiter(ruleConfig);
            default: // memory or default
                if (ruleConfig == null) {
                    return new MemoryRateLimiter();
                }
                return new MemoryRateLimiter(ruleConfig);
        }
    }
}
