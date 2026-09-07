package com.sdet.config;

import io.restassured.builder.RequestSpecBuilder;

public class BaseApiTest {

    protected io.restassured.specification.RequestSpecification requestSpecification() {

        return new RequestSpecBuilder()
                .setBaseUri(ApiConfig.BASE_URL)
                .build();
    }
}