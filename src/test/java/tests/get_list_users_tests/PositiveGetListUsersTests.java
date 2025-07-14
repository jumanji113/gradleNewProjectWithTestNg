package tests.get_list_users_tests;

import models.request.FullUser;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

import static assertions.Conditions.haseStatus;
import static utils.RandomTestData.getRandomUserWithGames;

public class PositiveGetListUsersTests extends BaseTest {
    @Test(groups = {"getUserInfo"})
    public void positiveGetUsersListTest() {
        FullUser userWithGames = getRandomUserWithGames();

        userService.register(userWithGames);

        List<String> users = userService.getAllUsers()
                .should(haseStatus(200)).asList(String.class);

        users.contains(userWithGames.getLogin());
    }
}
