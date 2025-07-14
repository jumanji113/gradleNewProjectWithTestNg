package tests.delete_user_tests;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.RandomTestData;

import static assertions.Conditions.*;

public class PositiveDeleteUserTests extends BaseTest {
    @Test(groups = {"deleteUser"})
    public void positiveRegisterTest() {
        FullUser fullUser = RandomTestData.getRandomUser();

        userService.register(fullUser)
                .should(haseStatus(201))
                .should(haseMessage("User created"));

        String token = userService.auth(fullUser).should(haseJwt()).asJwt();

        userService.deleteUser(token).should(haseMessage("User successfully deleted"));
    }
}
