package assertions.conditions;

import assertions.Condition;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;
import models.response.ErrorMessage;
import org.testng.Assert;

/**
 * Проверяет, что путь запроса совпадает с ожидаемым.
 */
@RequiredArgsConstructor
public class ErrorPathCondition implements Condition {
    private final String expectedPath;

    @Override
    public void check(ValidatableResponse response) {
        ErrorMessage errorMessage = response.extract().as(ErrorMessage.class);
        Assert.assertEquals(errorMessage.getPath(), expectedPath, "Путь не совпадает");
    }
}
