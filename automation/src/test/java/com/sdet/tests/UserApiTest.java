package com.sdet.tests;

import com.sdet.config.BaseApiTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserApiTest extends BaseApiTest {

    @Test
    void getUserShouldReturnSuccess() {

        var response =
                given()
                        .spec(requestSpecification())
                        .when()
                        .get("/users/1");

        assertEquals(200, response.statusCode());

        int userId = response.jsonPath().getInt("id");
        String name = response.jsonPath().getString("name");

        assertEquals(1, userId);
        assertEquals("Leanne Graham", name);
    }
}