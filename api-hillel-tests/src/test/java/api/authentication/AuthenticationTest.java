package api.authentication;

import base.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class AuthenticationTest extends BaseTest {

    @Test
    public void logOutTest() {
        RestAssured.when()
                .get("https://qauto.forstudy.space/api/auth/logout")
                .then()
                .statusCode(200)
                .body("status", equalTo("ok"));
    }
}
