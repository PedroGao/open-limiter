package com.pedro.ratelimiter;

import com.pedro.ratelimiter.exception.InternalErrorException;
import com.pedro.ratelimiter.rule.HashRateLimitRule;
import com.pedro.ratelimiter.rule.RateLimitRule;
import com.pedro.ratelimiter.rule.RuleConfig;
import com.pedro.ratelimiter.rule.datasource.FileRuleConfigSource;
import com.pedro.ratelimiter.rule.datasource.RuleConfigSource;

/**
 * 基于 Redis 的限流，待实现
 */
public class RedisRateLimiter implements RateLimiter {

    private RateLimitRule rule;

    public RedisRateLimiter() {
        RuleConfigSource configSource = new FileRuleConfigSource();
        RuleConfig ruleConfig = configSource.load();
        this.rule = new HashRateLimitRule(ruleConfig);
    }

    /* 直接传入配置 */
    public RedisRateLimiter(RuleConfig ruleConfig) {
        this.rule = new HashRateLimitRule(ruleConfig);
    }

    @Override
    public boolean limit(String api) throws InternalErrorException {
        return false;
    }
}
