package com.sdet.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.sdet.config.ApiSpecifications;
import com.sdet.model.UserRequest;
import com.sdet.model.UserResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    private final RequestSpecification requestSpecification;

    public UserApiClient(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Response getUser(int userId) {

        return given()
                .spec(requestSpecification)
                .when()
                .get("/users/" + userId)
                .then()
                .extract()
                .response();
    }

    public Response getAllUsers() {

        return given()
                .spec(requestSpecification)
                .when()
                .get("/users")
                .then()
                .extract()
                .response();
    }

    public Response createUser(UserRequest userRequest) {

        return given()
                .spec(requestSpecification)
                .body(userRequest)
                .when()
                .post("/users")
                .then()
                .extract()
                .response();
    }

    public Response updateUser(int userId, UserRequest userRequest) {

        return given()
                .spec(requestSpecification)
                .body(userRequest)
                .when()
                .put("/users/" + userId)
                .then()
                .extract()
                .response();
    }
    public Response deleteUser(int userId) {

        return given()
                .spec(requestSpecification)
                .when()
                .delete("/users/" + userId)
                .then()
                .extract()
                .response();
    }

    public Response createUser(JsonNode request) {

        return given()
                .spec(requestSpecification)
                .body(request)
                .when()
                .post("/users")
                .then()
                .extract()
                .response();
    }
}