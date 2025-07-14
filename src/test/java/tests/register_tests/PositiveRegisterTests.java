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
        FullUser fullUserWithoutGames = RandomTestData.getRandomUser();

        userService.register(fullUserWithoutGames)
                .should(haseStatus(201))
                .should(haseMessage("User created"));
    }

    @Test(groups = {"userSign"})
    public void positiveRegisterTestWithGames() {
        FullUser userWithGames = getRandomUserWithGames();

        userService.register(userWithGames).should(haseStatus(201))
                .should(haseMessage("User created"));
    }
}
