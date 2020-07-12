package com.pedro.ratelimiter.rule;

/**
 * 前缀树实现限流规则查找
 */
public class TrieRateLimitRule implements RateLimitRule {

    @Override
    public ApiLimit getLimit(String api) {
        return null;
    }
}
