package com.pedro.ratelimiter;

import com.pedro.ratelimiter.exception.InternalErrorException;

/**
 * 限流接口
 */
public interface RateLimiter {
    boolean limit(String api) throws InternalErrorException;
}
