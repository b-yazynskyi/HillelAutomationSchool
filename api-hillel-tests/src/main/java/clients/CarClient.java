package clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CarClient {

    public Response getCarBrands() {
        return given()
                .header("Content-Type", "application/json")
                .get("/cars/brands");
    }
}
