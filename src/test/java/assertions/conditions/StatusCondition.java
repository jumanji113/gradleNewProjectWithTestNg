package assertions.conditions;

import assertions.Condition;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;
import org.testng.Assert;

@RequiredArgsConstructor
public class StatusCondition implements Condition {
    private final Integer statuscode;

    @Override
    public void check(ValidatableResponse response) {
        Integer actualStatusCode = response.extract().statusCode();
        Assert.assertEquals(statuscode, actualStatusCode);
    }
}
