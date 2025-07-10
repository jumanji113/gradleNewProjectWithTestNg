package tests.update_user_info;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;
import java.util.UUID;

import static assertions.Conditions.haseMessage;
import static assertions.Conditions.haseStatus;
import static utils.RandomTestData.getAdminUser;

public class NegativeUpdateUserInfoTests extends BaseTest {
    @Test(groups = {"updateUser"})
    public void negativeUpdateUser() {
        String updatedPass = String.valueOf(UUID.randomUUID());
        FullUser admin = getAdminUser();

        String token = userService.auth(admin).asJwt();

        userService.updatePass(updatedPass, token)
                .should(haseStatus(400))
                .should(haseMessage("Cant update base users"));
    }
}
