package com.sdet.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.sdet.api.UserApiClient;
import com.sdet.config.ApiSpecifications;
import com.sdet.config.BaseApiTest;
import com.sdet.model.CreateUserResponse;
import com.sdet.model.UpdateUserResponse;
import com.sdet.model.UserRequest;
import com.sdet.model.UserResponse;
import com.sdet.utils.JsonUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserApiTest extends BaseApiTest {

    private final UserApiClient userApiClient =
            new UserApiClient(requestSpecification());


    @Test
    void getUserShouldReturnSuccess() {

        var response =
                userApiClient
                        .getUser(1)
                        .then()
                        .spec(ApiSpecifications.successResponseSpecification())
                        .extract()
                        .response();

        UserResponse user =
                response.as(UserResponse.class);

        assertEquals(1, user.getId());
        assertEquals("Leanne Graham", user.getName());
    }

    @Test
    void getAllUsersShouldReturnSuccess() {

        var response =
                userApiClient
                        .getAllUsers()
                        .then()
                        .spec(ApiSpecifications.successResponseSpecification())
                        .extract()
                        .response();


        int userCount = response.jsonPath().getList("$").size();

        assertEquals(10, userCount);
    }

    @Test
    void createUserShouldReturnCreated() {

        UserRequest userRequest =
                new UserRequest(
                        "Vishnu",
                        "vishnu",
                        "vishnu@example.com"
                );

        var response =
                userApiClient
                        .createUser(userRequest)
                        .then()
                        .spec(ApiSpecifications.createdResponseSpecification())
                        .extract()
                        .response();

        CreateUserResponse createdUser =
                response.as(CreateUserResponse.class);

        assertTrue(createdUser.getId() > 0);
    }
    @Test
    void updateUserShouldReturnSuccess() {

        UserRequest userRequest =
                new UserRequest(
                        "Vishnu Updated",
                        "vishnu_updated",
                        "updated@example.com"
                );

        var response =
                userApiClient
                        .updateUser(1, userRequest)
                        .then()
                        .spec(ApiSpecifications.successResponseSpecification())
                        .extract()
                        .response();

        UpdateUserResponse updatedUser =
                response.as(UpdateUserResponse.class);

        assertEquals(1, updatedUser.getId());
    }

    @Test
    void deleteUserShouldReturnSuccess() {

        var response =
                userApiClient.deleteUser(1);

        assertEquals(200, response.statusCode());
    }

    @Test
    void getNonExistingUserShouldReturnNotFound() {

        userApiClient
                .getUser(9999)
                .then()
                .spec(ApiSpecifications.notFoundResponseSpecification());
    }

    @Test
    void createUserUsingJsonTemplateShouldReturnCreated() {

        JsonNode request =
                JsonUtils.readJson("create-user.json");

        JsonUtils.setField(request, "name", "Vishnu Template");
        JsonUtils.setField(request, "email", "template@example.com");

        var response =
                userApiClient.createUser(request);

        response.then()
                .spec(ApiSpecifications.createdResponseSpecification());

        assertTrue(response.jsonPath().getInt("id") > 0);
    }
}