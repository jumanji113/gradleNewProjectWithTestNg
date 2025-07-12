package tests;

import config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import listeners.CustomTpl;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;
import services.UserService;

public class BaseTest {
    protected final UserService userService = new UserService();
    protected static ApiConfig config = ConfigFactory.create(ApiConfig.class);

    @BeforeSuite
    public static void setUp() {
        RestAssured.baseURI = config.baseUrl();

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(),
                CustomTpl.customLogFilter().withCustomTemplates());
    }
}
