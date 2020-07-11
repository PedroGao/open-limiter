package com.pedro.ratelimiter.rule;

public interface RateLimitRule {
    ApiLimit getLimit(String api);
}
