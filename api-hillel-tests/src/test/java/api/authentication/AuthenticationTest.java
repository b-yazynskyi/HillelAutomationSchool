package api.authentication;

import base.BaseTest;
import clients.AuthClient;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import responses.GetLogOutResponse;

import static utils.JsonUtils.fromJson;


public class AuthenticationTest extends BaseTest {
    private AuthClient authClient;

    @BeforeClass
    public void initClients() {
        authClient = new AuthClient();
    }

    @Test
    public void logOutTest() {
        var response = authClient.getLogOut();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200, "Status code should be 200");

        GetLogOutResponse getLogOutResponse = fromJson(response.getBody().asString(), GetLogOutResponse.class);
        softAssert.assertEquals(getLogOutResponse.getStatus(), "ok", "Status should be ok");
        softAssert.assertAll();
    }
}
