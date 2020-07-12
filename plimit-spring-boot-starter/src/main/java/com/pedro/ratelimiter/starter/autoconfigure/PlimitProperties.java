package com.pedro.ratelimiter.starter.autoconfigure;

import com.pedro.ratelimiter.rule.RuleConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "plimit")
public class PlimitProperties {
    // 限流算法选择，目前只支持固定窗口算法
    private String strategy;

    // 限流方式选择
    private String storage;

    // 限流规则配置
    private RuleConfig ruleConfig;

    // todo 限流查找方式选择

    public RuleConfig getRuleConfig() {
        return ruleConfig;
    }

    public void setRuleConfig(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
