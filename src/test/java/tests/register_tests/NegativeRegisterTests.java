package tests.register_tests;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.RandomTestData;

import static assertions.Conditions.haseMessage;
import static assertions.Conditions.haseStatus;

public class NegativeRegisterTests extends BaseTest {
    @Test(groups = {"userSign"})
    public void negativeRegisterTest() {
        FullUser fullUserWithoutGames = RandomTestData.getRandomUser();

        userService.register(fullUserWithoutGames)
                .should(haseStatus(201))
                .should(haseMessage("User created"));

        userService.register(fullUserWithoutGames)
                .should(haseStatus(400))
                .should(haseMessage("Login already exist"));
    }
}
