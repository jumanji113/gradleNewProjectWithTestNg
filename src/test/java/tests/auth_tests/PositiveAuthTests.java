package tests.auth_tests;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;

import static assertions.Conditions.haseJwt;
import static assertions.Conditions.haseStatus;
import static utils.RandomTestData.getAdminUser;
import static utils.RandomTestData.getRandomUserWithGames;

public class PositiveAuthTests extends BaseTest {
    @Test(groups = {"authUser"})
    public void positiveAuthNewUser(){
        FullUser user = getRandomUserWithGames();

        userService.register(user);

        userService.auth(user)
                .should(haseStatus(200))
                .should(haseJwt());
    }

    @Test(groups = {"authUser"})
    public void positiveAuthAdmin(){
        FullUser admin = getAdminUser();

        userService.auth(admin)
                .should(haseStatus(200))
                .should(haseJwt());
    }
}
