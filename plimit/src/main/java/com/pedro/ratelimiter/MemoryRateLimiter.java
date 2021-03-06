package com.pedro.ratelimiter;

import com.pedro.ratelimiter.alg.FixedTimeWinRateLimitAlg;
import com.pedro.ratelimiter.alg.RateLimitAlg;
import com.pedro.ratelimiter.exception.InternalErrorException;
import com.pedro.ratelimiter.rule.ApiLimit;
import com.pedro.ratelimiter.rule.HashRateLimitRule;
import com.pedro.ratelimiter.rule.RateLimitRule;
import com.pedro.ratelimiter.rule.RuleConfig;
import com.pedro.ratelimiter.rule.datasource.FileRuleConfigSource;
import com.pedro.ratelimiter.rule.datasource.RuleConfigSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 内存单机版的限流
 */
public class MemoryRateLimiter implements RateLimiter {
    private static final Logger log = LoggerFactory.getLogger(MemoryRateLimiter.class);

    // 每个 endpoint 均有一个限流存储器
    private final ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimitRule rule;

    public MemoryRateLimiter() {
        RuleConfigSource configSource = new FileRuleConfigSource();
        RuleConfig ruleConfig = configSource.load();
        this.rule = new HashRateLimitRule(ruleConfig);
    }

    /* 直接传入配置 */
    public MemoryRateLimiter(RuleConfig ruleConfig) {
        this.rule = new HashRateLimitRule(ruleConfig);
    }

    @Override
    public boolean limit(String api) throws InternalErrorException {
        ApiLimit apiLimit = rule.getLimit(api);
        if (apiLimit == null) {
            return true;
        }
        // 获取api对应在内存中的限流计数器（rateLimitCounter）
        String counterKey = apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null) {
            // TODO 后面提供配置，更换固定时间窗口
            RateLimitAlg newRateLimitCounter = new FixedTimeWinRateLimitAlg(apiLimit.getLimit());
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if (rateLimitCounter == null) {
                rateLimitCounter = newRateLimitCounter;
            }
        }    // 判断是否限流
        return rateLimitCounter.tryAcquire();
    }
}
