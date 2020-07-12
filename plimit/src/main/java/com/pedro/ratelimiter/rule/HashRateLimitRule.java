package com.pedro.ratelimiter.rule;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 哈希表实现查找
 */
public class HashRateLimitRule implements RateLimitRule {
    private RuleConfig ruleConfig;
    private ConcurrentHashMap<String, ApiLimit> limitMap = new ConcurrentHashMap<>();

    public HashRateLimitRule(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
        ruleConfig.getLimits().forEach(limit -> {
            limitMap.put(limit.getApi(), limit);
        });
    }

    @Override
    public ApiLimit getLimit(String api) {
        return limitMap.get(api);
    }
}
