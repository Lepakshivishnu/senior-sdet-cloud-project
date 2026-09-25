package com.sdet.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.UUID;

public class RequestSpecFactory {

    public static RequestSpecification create() {

        return new RequestSpecBuilder()
                .setBaseUri(ApiConfig.BASE_URL)
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .addHeader("X-Correlation-ID", UUID.randomUUID().toString())
                .setConfig(
                        RestAssuredConfig.config()
                                .logConfig(
                                        LogConfig.logConfig()
                                                .enableLoggingOfRequestAndResponseIfValidationFails()
                                )
                )
                .build();
    }
}