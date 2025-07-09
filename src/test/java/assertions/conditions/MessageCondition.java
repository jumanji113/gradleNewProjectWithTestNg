package assertions.conditions;

import assertions.Condition;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;
import models.Info;
import models.RegisterDataInfo;
import org.testng.Assert;

@RequiredArgsConstructor
public class MessageCondition implements Condition {

    private final String expectedMessage;

    @Override
    public void check(ValidatableResponse response) {
        RegisterDataInfo info = response.extract().as(RegisterDataInfo.class);
        Assert.assertEquals(expectedMessage, info.getInfo().getMessage());
    }
}
