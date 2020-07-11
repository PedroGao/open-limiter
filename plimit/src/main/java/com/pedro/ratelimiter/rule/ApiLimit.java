package com.pedro.ratelimiter.rule;

public class ApiLimit {
    private static final int DEFAULT_UNIT = 1; // 默认 1 s
    private String api;
    private int limit;
    private int unit = DEFAULT_UNIT;

    public ApiLimit() {
    }

    public ApiLimit(String api, int limit) {
        this(api, limit, DEFAULT_UNIT);
    }

    public ApiLimit(String api, int limit, int unit) {
        this.api = api;
        this.limit = limit;
        this.unit = unit;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
