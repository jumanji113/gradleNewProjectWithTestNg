package tests.update_user_info_tests;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.UUID;

import static assertions.Conditions.haseMessage;
import static utils.RandomTestData.getRandomUserWithGames;

public class PositiveUpdateUserInfoTests extends BaseTest {
    @Test(groups = {"updateUser"})
    public void positiveUpdateUser() {
        FullUser userWithGames = getRandomUserWithGames();
        String randomPass = String.valueOf(UUID.randomUUID());

        userService.register(userWithGames);

        String token = userService.auth(userWithGames).asJwt();

        userService.updatePass(randomPass, token)
                .should(haseMessage("User password successfully changed"));
    }
}
