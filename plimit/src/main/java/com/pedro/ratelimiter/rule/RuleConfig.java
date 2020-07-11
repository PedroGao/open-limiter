package com.pedro.ratelimiter.rule;

import java.util.List;

public class RuleConfig {
    private List<ApiLimit> limits;

    public List<ApiLimit> getLimits() {
        return limits;
    }

    public void setLimits(List<ApiLimit> limits) {
        this.limits = limits;
    }
}
