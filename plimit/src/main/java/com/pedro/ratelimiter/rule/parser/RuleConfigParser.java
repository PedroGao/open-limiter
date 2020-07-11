package com.pedro.ratelimiter.rule.parser;

import com.pedro.ratelimiter.rule.RuleConfig;

import java.io.InputStream;

public interface RuleConfigParser {
    RuleConfig parse(String configText);

    RuleConfig parse(InputStream in);
}
