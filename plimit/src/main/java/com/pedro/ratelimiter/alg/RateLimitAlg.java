package com.pedro.ratelimiter.alg;

import com.pedro.ratelimiter.exception.InternalErrorException;

/**
 * 限流算法接口
 */
public interface RateLimitAlg {
    /**
     * 获取访问权
     *
     * @return 是否可以访问
     */
    boolean tryAcquire() throws InternalErrorException;
}