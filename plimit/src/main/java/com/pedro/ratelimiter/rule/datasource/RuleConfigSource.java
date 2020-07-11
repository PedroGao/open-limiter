package com.pedro.ratelimiter.rule.datasource;

import com.pedro.ratelimiter.rule.RuleConfig;

public interface RuleConfigSource {
    RuleConfig load();
}
