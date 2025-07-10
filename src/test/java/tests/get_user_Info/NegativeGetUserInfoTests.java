package tests.get_user_Info;

import org.testng.annotations.Test;
import tests.BaseTest;

import static assertions.Conditions.haseStatus;

public class NegativeGetUserInfoTests extends BaseTest {

    @Test(groups = {"getUserInfo"})
    public void negativeGetUserInfo() {
        userService.getUserInfo("some token")
                .should(haseStatus(401));
    }
}
