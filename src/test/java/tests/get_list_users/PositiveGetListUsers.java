package tests.get_list_users;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

import static assertions.Conditions.haseStatus;
import static utils.RandomTestData.getRandomUserWithGames;

public class PositiveGetListUsers extends BaseTest {
    @Test(groups = {"getUserInfo"})
    public void positiveGetUserInfoTest() {
        FullUser user = getRandomUserWithGames();

        userService.register(user);

        List<String> users = userService.getAllUsers()
                .should(haseStatus(200)).asList(String.class);

        users.contains(user.getLogin());
    }
}
