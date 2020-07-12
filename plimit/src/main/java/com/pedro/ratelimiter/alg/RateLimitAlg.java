package com.pedro.ratelimiter.alg;

import com.pedro.ratelimiter.exception.InternalErrorException;

public interface RateLimitAlg {
    boolean tryAcquire() throws InternalErrorException;
}