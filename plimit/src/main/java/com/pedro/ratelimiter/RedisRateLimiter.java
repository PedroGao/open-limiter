package com.pedro.ratelimiter;

import com.pedro.ratelimiter.exception.InternalErrorException;

/**
 * 基于 Redis 的限流，待实现
 */
public class RedisRateLimiter implements RateLimiter {
    @Override
    public boolean limit(String api) throws InternalErrorException {
        return false;
    }
}
