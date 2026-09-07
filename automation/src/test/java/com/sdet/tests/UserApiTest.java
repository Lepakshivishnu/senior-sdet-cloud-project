package com.sdet.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserApiTest {

    @Test
    void getUserShouldReturnSuccess() {

        Response response =
                given()
                        .when()
                        .get("https://jsonplaceholder.typicode.com/users/1");

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());
    }
}