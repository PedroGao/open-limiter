package com.pedro.ratelimiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RateLimiterTest {

    @Test
    void limit() {
        RateLimiter limiter = new RateLimiter();
        boolean ok = limiter.limit("GET /v1/user");
        Assertions.assertTrue(ok);
    }
}