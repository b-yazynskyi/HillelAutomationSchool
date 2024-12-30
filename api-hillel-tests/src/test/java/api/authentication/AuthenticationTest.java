package api.authentication;

import base.BaseTest;
import clients.AuthClient;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import responses.GetLogOutResponse;

import static utils.JsonUtils.fromJson;

@Feature("Route GET /auth/logout")
public class AuthenticationTest extends BaseTest {
    private AuthClient authClient;

    @BeforeClass
    public void initClients() {
        authClient = new AuthClient();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Assert that logout GET request returns 200 and status: ok")
    @Owner("Bohdan Yazynskyi")
    @Test(testName = "logOutTest",
            description = "Assert that logout GET request returns 200 and status: ok"
    )
    public void logOutTest() {
        var response = authClient.getLogOut();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200, "Status code should be 200");

        GetLogOutResponse getLogOutResponse = fromJson(response.getBody().asString(), GetLogOutResponse.class);
        softAssert.assertEquals(getLogOutResponse.getStatus(), "ok", "Status should be ok");
        softAssert.assertAll();
    }
}
