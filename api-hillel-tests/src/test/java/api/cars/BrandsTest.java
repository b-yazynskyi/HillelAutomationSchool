package api.cars;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class BrandsTest {

    @Test
    public void brandTest() {
        RestAssured.when()
                .get("https://qauto.forstudy.space/api/cars/brands")
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo(1))
                .body("data[0].title", equalTo("Audi"))
                .log().all();
    }
}
