package assertions.conditions;

import assertions.Condition;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;
import models.response.ErrorMessage;
import org.testng.Assert;

@RequiredArgsConstructor
public class ErrorStatusCondition implements Condition {
    private final int expectedStatus;

    @Override
    public void check(ValidatableResponse response) {
        ErrorMessage errorMessage = response.extract().as(ErrorMessage.class);
        Assert.assertEquals(errorMessage.getStatus(), Integer.valueOf(expectedStatus), "Статус не совпадает");
    }
}
