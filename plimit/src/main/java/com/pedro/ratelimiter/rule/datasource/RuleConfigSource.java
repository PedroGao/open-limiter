package com.pedro.ratelimiter.rule.datasource;

import com.pedro.ratelimiter.rule.RuleConfig;

/**
 * 配置文件加载器
 */
public interface RuleConfigSource {
    RuleConfig load();
}
