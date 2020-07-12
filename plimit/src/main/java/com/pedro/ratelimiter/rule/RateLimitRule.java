package com.pedro.ratelimiter.rule;

/**
 * 限流规则查找器
 */
public interface RateLimitRule {
    ApiLimit getLimit(String api);
}
