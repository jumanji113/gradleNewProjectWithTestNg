package controllers;

import io.restassured.http.ContentType;
import models.FullUser;
import models.RegisterDataInfo;

import static io.restassured.RestAssured.given;

public class UserApiController {

    public RegisterDataInfo registerUser(FullUser user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("signup")
                .then()
                .statusCode(201)
                .extract()
                .as(RegisterDataInfo.class);
    }
}
