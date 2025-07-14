package tests.get_user_Info_tests;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.RandomTestData;

import static assertions.Conditions.*;
import static assertions.Conditions.haseMessage;
import static utils.RandomTestData.getAdminUser;

public class PositiveGetUserInfoTests extends BaseTest {
    @Test(groups = {"getUserInfo"})
    public void positiveGetUserInfoTest() {
        FullUser fullUserWithoutGames = RandomTestData.getRandomUser();

        userService.register(fullUserWithoutGames)
                .should(haseStatus(201))
                .should(haseMessage("User created"));

        String token = userService.auth(fullUserWithoutGames).should(haseJwt()).asJwt();

        userService.getUserInfo(token)
                .should(haseStatus(200))
                .should(hasUserInfo(fullUserWithoutGames));
    }

    @Test(groups = {"getUserInfo"})
    public void positiveGetAdminUserInfoTest() {
        FullUser admin = getAdminUser();

        String token = userService.auth(admin).should(haseJwt()).asJwt();

        userService.getUserInfo(token)
                .should(haseStatus(200))
                .should(hasUserInfo(admin));
    }
}
