package com.pedro.ratelimiter.rule.parser;

import com.pedro.ratelimiter.rule.RuleConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

public class YamlRuleConfigParser implements RuleConfigParser {

    @Override
    public RuleConfig parse(String configText) {
        Yaml yaml = new Yaml();
        return yaml.loadAs(configText, RuleConfig.class);
    }

    @Override
    public RuleConfig parse(InputStream in) {
        Yaml yaml = new Yaml();
        return yaml.loadAs(in, RuleConfig.class);
    }
}
