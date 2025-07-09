package tests.DeleteUserTests;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;

import static assertions.Conditions.*;
import static assertions.Conditions.haseMessage;
import static utils.RandomTestData.getAdminUser;

public class NegativeDeleteUserTest extends BaseTest {
    @Test(groups = {"deleteUser"})
    public void negativeRegisterTest() {
        FullUser admin = getAdminUser();

        String token = userService.auth(admin).should(haseJwt()).asJwt();

        userService.deleteUser(token).should(haseMessage("Cant delete base users"));
    }
}
