package com.sdet.config;

public class ApiConfig {

    private static final String ENVIRONMENT =
            System.getProperty("env", "qa");

    private static final ConfigReader CONFIG_READER =
            new ConfigReader(ENVIRONMENT);

    public static final String BASE_URL =
            CONFIG_READER.get("base.url");
}