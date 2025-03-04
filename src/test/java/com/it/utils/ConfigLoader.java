package com.it.utils;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.net.URL;

public class ConfigLoader {
    private PropertiesConfiguration config;

    public ConfigLoader(String resourcePath) {
        try {
            Configurations configs = new Configurations();
            URL resourceUrl = getClass().getClassLoader().getResource(resourcePath);
            if (resourceUrl == null) {
                throw new RuntimeException("Properties file not found: " + resourcePath);
            }
            this.config = configs.properties(resourceUrl);
        } catch (ConfigurationException e) {
            throw new RuntimeException("Failed to load properties file: " + resourcePath, e);
        }
    }

    public String get(String key) {
        return config.getString(key);
    }
}

