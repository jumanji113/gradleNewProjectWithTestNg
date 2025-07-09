package assertions;

import assertions.conditions.MessageCondition;
import assertions.conditions.StatusCondition;

public class Conditions {
    public static MessageCondition haseMessage(String expectedMessage){
        return new MessageCondition(expectedMessage);
    }

    public static StatusCondition haseStatus(Integer expectedStatus){
        return new StatusCondition(expectedStatus);
    }
}
