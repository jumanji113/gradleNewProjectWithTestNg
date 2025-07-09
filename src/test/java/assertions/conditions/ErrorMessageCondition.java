package assertions.conditions;

import assertions.Condition;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;
import models.ErrorMessage;
import org.testng.Assert;

@RequiredArgsConstructor
public class ErrorMessageCondition implements Condition {
    private final String expectedMessage;

    @Override
    public void check(ValidatableResponse response) {
        ErrorMessage errorMessage = response.extract().as(ErrorMessage.class);
        Assert.assertEquals(expectedMessage, errorMessage.getError(), "Ошибка не совпадает");
    }
}
