package assertions.conditions;

import assertions.Condition;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;

public class JwtCondition implements Condition {
    @Override
    public void check(ValidatableResponse response) {
        String jwt = response.extract().jsonPath().getString("token");
        Assert.assertNotNull(jwt);
    }
}
