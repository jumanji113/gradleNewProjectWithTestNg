package tests.delete_user_tests;

import io.qameta.allure.testng.Tag;
import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.RandomTestData;

import static assertions.Conditions.*;

public class PositiveDeleteUserTests extends BaseTest {
    @Test(groups = {"deleteUser"})
    @Tag("")
    public void positiveDeleteUserTest() {
        FullUser fullUserWithoutGames = RandomTestData.getRandomUser();

        userService.register(fullUserWithoutGames)
                .should(haseStatus(201))
                .should(haseMessage("User created"));

        String token = userService.auth(fullUserWithoutGames).should(haseJwt()).asJwt();

        userService.deleteUser(token).should(haseMessage("User successfully deleted"));
    }
}
