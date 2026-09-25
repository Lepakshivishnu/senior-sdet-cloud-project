package com.sdet.config;

import io.restassured.specification.RequestSpecification;

public class BaseApiTest {

    protected RequestSpecification requestSpecification() {
        return RequestSpecFactory.create();
    }
}