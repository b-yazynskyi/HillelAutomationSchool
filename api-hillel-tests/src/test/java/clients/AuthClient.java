package clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthClient {

    public Response getLogOut() {
        return given()
                .header("Content-Type", "application/json")
                .get("/auth/logout");
    }
}
