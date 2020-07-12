# open-limiter

> 注意：暂不考虑业务实现，单纯考虑「限流」的设计策略和实现思路。

## 方案

### 限流规则

接口、限流阈值和时间段，如下：

```yaml
limits:
- api: GET /v1/user
  limit: 100
  unit: 60
```
配置文件多样化，支持 yaml，json 和 properties 等等...
### 限流算法

常见的限流算法有：固定时间窗口限流算法、滑动时间窗口限流算法、令牌桶限流算法、漏桶限流算法。

简单的可以直接选择「固定时间窗口限流算法」。

限流算法多样化，支持多种算法配置切换。

### 限流模式

单机内存限流和 Redis 服务限流。

支持两种模式配置自由切换。

### 使用模式

方便集成 spring-boot，starter 一键搞定。

## 实现

### v1

v1 版代码结构如下：

```plain
plimit/src/main/java/com/pedro/ratelimiter
├── MemoryRateLimiter.java // 内存限流
├── RateLimiter.java // 限流接口
├── RedisRateLimiter.java // Redis 限流
├── alg // 限流算法
│   ├── FixedTimeWinRateLimitAlg.java 固定窗口限流算法
│   └── RateLimitAlg.java 限流算法接口
├── exception // 异常
│   └── InternalErrorException.java
└── rule // 限流规则
    ├── ApiLimit.java // 配置项
    ├── HashRateLimitRule.java // 哈希表规则查找
    ├── RateLimitRule.java // 限流规则查找
    ├── RuleConfig.java // 配置类
    ├── TrieRateLimitRule.java // 前缀树规则查找
    ├── datasource // 配置数据源
    │   ├── FileRuleConfigSource.java // 文件配置
    │   └── RuleConfigSource.java // 配置数据源接口
    └── parser // 配置解析
        ├── JsonRuleConfigParser.java // json 配置解析
        ├── RuleConfigParser.java // 解析接口
        └── YamlRuleConfigParser.java // yaml 配置解析
```



