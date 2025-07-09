package tests.AuthTests;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;

import static assertions.Conditions.*;
import static utils.RandomTestData.getRandomUserWithGames;

public class NegativeAuthTests extends BaseTest {
    @Test(groups = {"authUser"})
    public void negativeAuthUser(){
        FullUser user = getRandomUserWithGames();
        userService.auth(user)
                .should(haseErrorStatus(401))
                .should(haseMessageError("Unauthorized"))
                .should(hasePathErrorMessage("/api/login"));
    }
}
