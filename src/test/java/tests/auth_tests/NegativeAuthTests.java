package tests.auth_tests;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;

import static assertions.Conditions.*;
import static utils.RandomTestData.getRandomUserWithGames;

public class NegativeAuthTests extends BaseTest {
    @Test(groups = {"authUser"})
    public void negativeAuthUser(){
        FullUser userWithGames = getRandomUserWithGames();

        userService.auth(userWithGames)
                .should(haseErrorStatus(401))
                .should(haseMessageError("Unauthorized"))
                .should(hasePathErrorMessage("/api/login"));
    }
}
