package tests;

import controllers.UserApiController;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import listeners.CustomTpl;
import models.FullUser;
import models.RegisterDataInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.RandomTestData;

public class UserTest {

    private final UserApiController userApi = new UserApiController();

    @BeforeSuite
    public static void setUp() {
        RestAssured.baseURI = "http://85.192.34.140:8080/api";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(),
                CustomTpl.customLogFilter().withCustomTemplates());
    }

    @Test(groups = {"userSign"})
    public void positiveRegisterTest() {
        FullUser fullUser = RandomTestData.getRandomUser();
        RegisterDataInfo registerDataInfo = userApi.registerUser(fullUser);

        Assert.assertEquals(fullUser.getPass(), registerDataInfo.getRegisterData().getPass());
        Assert.assertEquals(fullUser.getLogin(), registerDataInfo.getRegisterData().getLogin());
        Assert.assertNotNull(registerDataInfo.getRegisterData().getId());
        Assert.assertEquals("User created", registerDataInfo.getInfo().getMessage());
        Assert.assertEquals("success", registerDataInfo.getInfo().getStatus());
    }
}
