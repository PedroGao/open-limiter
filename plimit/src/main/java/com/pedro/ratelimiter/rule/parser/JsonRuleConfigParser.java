package com.pedro.ratelimiter.rule.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pedro.ratelimiter.rule.RuleConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class JsonRuleConfigParser implements RuleConfigParser {

    private static final Logger log = LoggerFactory.getLogger(JsonRuleConfigParser.class);

    @Override
    public RuleConfig parse(String configText) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            RuleConfig config = mapper.readValue(configText, RuleConfig.class);
            return config;
        } catch (JsonProcessingException e) {
            //noinspection PlaceholderCountMatchesArgumentCount
            log.error("read json config file err: {}", e);
        }
        return null;
    }

    @Override
    public RuleConfig parse(InputStream in) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            RuleConfig config = mapper.readValue(in, RuleConfig.class);
            return config;
        } catch (IOException e) {
            //noinspection PlaceholderCountMatchesArgumentCount
            log.error("read json config file err: {}", e);
        }
        return null;
    }
}
