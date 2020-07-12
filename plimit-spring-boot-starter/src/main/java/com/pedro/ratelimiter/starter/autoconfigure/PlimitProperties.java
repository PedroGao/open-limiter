package com.pedro.ratelimiter.starter.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "plimit")
public class PlimitProperties {
    private String limitStrategy;

    public String getLimitStrategy() {
        return limitStrategy;
    }

    public void setLimitStrategy(String limitStrategy) {
        this.limitStrategy = limitStrategy;
    }
}
