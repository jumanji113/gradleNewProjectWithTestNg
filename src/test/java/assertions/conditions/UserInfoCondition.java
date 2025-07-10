package assertions.conditions;

import assertions.Condition;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;
import models.request.FullUser;
import org.testng.Assert;

/**
 * Проверяет, что поля login, pass и games в ответе совпадают с ожидаемым пользователем.
 */
@RequiredArgsConstructor
public class UserInfoCondition implements Condition {
    private final FullUser expectedUser;

    @Override
    public void check(ValidatableResponse response) {
        FullUser actualUser = response.extract().as(FullUser.class);

        Assert.assertEquals(actualUser.getLogin(), expectedUser.getLogin(), "Логин не совпадает");
        Assert.assertEquals(actualUser.getPass(), expectedUser.getPass(), "Пароль не совпадает");
        // Если нужно, можно добавить проверку games:
        if (expectedUser.getGames() != null) {
            Assert.assertEquals(actualUser.getGames(), expectedUser.getGames(), "Список игр не совпадает");
        }
    }
}
