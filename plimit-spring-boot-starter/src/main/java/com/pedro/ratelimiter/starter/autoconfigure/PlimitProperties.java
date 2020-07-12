package com.pedro.ratelimiter.starter.autoconfigure;

import com.pedro.ratelimiter.rule.RuleConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "plimit")
public class PlimitProperties {
    private String limitStrategy;
    private RuleConfig ruleConfig;

    public String getLimitStrategy() {
        return limitStrategy;
    }

    public void setLimitStrategy(String limitStrategy) {
        this.limitStrategy = limitStrategy;
    }

    public RuleConfig getRuleConfig() {
        return ruleConfig;
    }

    public void setRuleConfig(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }
}
