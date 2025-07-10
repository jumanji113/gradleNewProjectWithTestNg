package tests.get_user_Info;

import models.request.FullUser;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.RandomTestData;

import static assertions.Conditions.*;
import static assertions.Conditions.haseMessage;
import static utils.RandomTestData.getAdminUser;

public class PositiveGetUserInfo extends BaseTest {

    @Test(groups = {"getUserInfo"})
    public void positiveGetUserInfoTest() {
        FullUser fullUser = RandomTestData.getRandomUser();

        userService.register(fullUser)
                .should(haseStatus(201))
                .should(haseMessage("User created"));

        String token = userService.auth(fullUser).should(haseJwt()).asJwt();

        FullUser actualUser = userService.getUserInfo(token)
                .should(haseStatus(200))
                .as(FullUser.class);

        Assert.assertEquals(fullUser.getLogin(), actualUser.getLogin());
        Assert.assertEquals(fullUser.getPass(), actualUser.getPass());
    }

    @Test(groups = {"getUserInfo"})
    public void positiveGetAdminUserInfoTest() {
        FullUser admin = getAdminUser();

        String token = userService.auth(admin).should(haseJwt()).asJwt();

        FullUser actualUser = userService.getUserInfo(token)
                .should(haseStatus(200))
                .as(FullUser.class);

        Assert.assertEquals(admin.getLogin(), actualUser.getLogin());
        Assert.assertEquals(admin.getPass(), actualUser.getPass());
        Assert.assertNotNull(actualUser.getGames());
    }
}
