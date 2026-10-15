package com.github.dependabot;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.util.Map;

/**
 * Local-only SnakeYAML API migration example for the Dependabot demo.
 */
public class DemoConfig {
    public String message;

    public static void main(String[] args) {
        // Keep the input benign and local. SafeConstructor limits deserialization
        // to standard YAML types instead of constructing arbitrary Java classes.
        String yaml = "message: hello from the demo";
        Map<?, ?> values = new Yaml(new SafeConstructor(new LoaderOptions())).load(yaml);
        DemoConfig config = new DemoConfig();
        config.message = (String) values.get("message");
        System.out.println(config.message);
    }
}
