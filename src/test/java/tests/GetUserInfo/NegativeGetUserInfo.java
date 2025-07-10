package tests.GetUserInfo;

import org.testng.annotations.Test;
import tests.BaseTest;

import static assertions.Conditions.haseStatus;

public class NegativeGetUserInfo extends BaseTest {

    @Test(groups = {"getUserInfo"})
    public void negativeGetUserInfo() {
        userService.getUserInfo("some token")
                .should(haseStatus(401));
    }
}
