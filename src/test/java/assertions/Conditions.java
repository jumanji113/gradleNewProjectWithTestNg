package assertions;

import assertions.conditions.*;

public class Conditions {
    public static MessageCondition haseMessage(String expectedMessage) {
        return new MessageCondition(expectedMessage);
    }

    public static StatusCondition haseStatus(Integer expectedStatus) {
        return new StatusCondition(expectedStatus);
    }

    public static JwtCondition haseJwt() {
        return new JwtCondition();
    }

    public static ErrorMessageCondition haseMessageError(String expectedMessage) {
        return new ErrorMessageCondition(expectedMessage);
    }

    public static ErrorStatusCondition haseErrorStatus(Integer expectedErrorStatus) {
        return new ErrorStatusCondition(expectedErrorStatus);
    }

    public static ErrorPathCondition hasePathErrorMessage(String expectedErrorStatus) {
        return new ErrorPathCondition(expectedErrorStatus);
    }
}
