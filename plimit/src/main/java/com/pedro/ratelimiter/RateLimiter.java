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

public class RateLimiter {
    private static final Logger log = LoggerFactory.getLogger(RateLimiter.class);

    // 每个 endpoint 均有一个限流存储器
    private final ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimitRule rule;

    public RateLimiter() {
        //改动主要在这里：调用RuleConfigSource类来实现配置加载
        RuleConfigSource configSource = new FileRuleConfigSource();
        RuleConfig ruleConfig = configSource.load();
        this.rule = new HashRateLimitRule(ruleConfig);
    }

    public boolean limit(String api) throws InternalErrorException {
        ApiLimit apiLimit = rule.getLimit(api);
        if (apiLimit == null) {
            return true;
        }
        // 获取api对应在内存中的限流计数器（rateLimitCounter）
        String counterKey = apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null) {
            RateLimitAlg newRateLimitCounter = new FixedTimeWinRateLimitAlg(apiLimit.getLimit());
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if (rateLimitCounter == null) {
                rateLimitCounter = newRateLimitCounter;
            }
        }    // 判断是否限流
        return rateLimitCounter.tryAcquire();
    }
}
