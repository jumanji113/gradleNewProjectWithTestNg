package tests.RegisterTest;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.RandomTestData;

import static assertions.Conditions.haseMessage;
import static assertions.Conditions.haseStatus;

public class NegativeRegisterTest extends BaseTest {

    @Test(groups = {"userSign"})
    public void negativeRegisterTest() {
        FullUser fullUser = RandomTestData.getRandomUser();

        userService.register(fullUser)
                .should(haseStatus(201))
                .should(haseMessage("User created"));

        userService.register(fullUser)
                .should(haseStatus(400))
                .should(haseMessage("Login already exist"));
    }
}
