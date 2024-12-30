package api.authentication;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class AuthenticationTest {

    @Test
    public void logOutTest() {
        RestAssured.when()
                .get("https://qauto.forstudy.space/api/auth/logout")
                .then()
                .statusCode(200)
                .body("status", equalTo("ok"));
    }
}
