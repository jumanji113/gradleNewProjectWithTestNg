package tests;

import assertions.AssertableResponse;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import listeners.CustomTpl;
import models.FullUser;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import services.UserService;
import utils.RandomTestData;

import static assertions.Conditions.haseMessage;
import static assertions.Conditions.haseStatus;
import static io.restassured.RestAssured.given;
import static utils.RandomTestData.getRandomUserWithGames;

public class UserTest {

    private final UserService userService = new UserService();

    @BeforeSuite
    public static void setUp() {
        RestAssured.baseURI = "http://85.192.34.140:8080/api";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(),
                CustomTpl.customLogFilter().withCustomTemplates());
    }

    @Test(groups = {"userSign"})
    public void positiveRegisterTest() {
        FullUser fullUser = RandomTestData.getRandomUser();
        userService.register(fullUser)
                .should(haseStatus(201))
                .should(haseMessage("User created"));
    }

    @Test(groups = {"userSign"})
    public void positiveRegisterTestWithService(){
        FullUser user = getRandomUserWithGames();
        userService.register(user).should(haseStatus(201))
                .should(haseMessage("User created"));
    }
}
