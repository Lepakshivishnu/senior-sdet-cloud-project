package com.sdet.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties = new Properties();

    public ConfigReader(String environment) {

        String fileName = "config/" + environment + ".properties";

        try (InputStream inputStream =
                     getClass().getClassLoader().getResourceAsStream(fileName)) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "Configuration file not found: " + fileName);
            }

            properties.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load configuration: " + fileName, e);
        }
    }

    public String get(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new RuntimeException(
                    "Configuration key not found or empty: " + key);
        }

        return value;
    }
}