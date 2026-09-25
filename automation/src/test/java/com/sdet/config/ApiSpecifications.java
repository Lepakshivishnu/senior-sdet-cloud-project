package com.sdet.config;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ApiSpecifications {

    public static ResponseSpecification successResponseSpecification() {

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification createdResponseSpecification() {

        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }

    public static ResponseSpecification notFoundResponseSpecification() {

        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }
}