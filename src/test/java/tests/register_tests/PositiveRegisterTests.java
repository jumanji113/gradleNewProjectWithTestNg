package tests.register_tests;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.RandomTestData;

import static assertions.Conditions.haseMessage;
import static assertions.Conditions.haseStatus;
import static utils.RandomTestData.getRandomUserWithGames;

public class PositiveRegisterTests extends BaseTest {
    @Test(groups = {"userSign"})
    public void positiveRegisterTest() {
        FullUser fullUser = RandomTestData.getRandomUser();

        userService.register(fullUser)
                .should(haseStatus(201))
                .should(haseMessage("User created"));
    }

    @Test(groups = {"userSign"})
    public void positiveRegisterTestWithGames() {
        FullUser user = getRandomUserWithGames();

        userService.register(user).should(haseStatus(201))
                .should(haseMessage("User created"));
    }
}
