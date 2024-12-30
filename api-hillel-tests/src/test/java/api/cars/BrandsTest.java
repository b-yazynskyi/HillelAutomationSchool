package api.cars;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.hamcrest.Matchers.equalTo;

public class BrandsTest {

    @Test
    public void brandTestWithRestAssured() {
        RestAssured.when()
                .get("https://qauto.forstudy.space/api/cars/brands")
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo(1))
                .body("data[0].title", equalTo("Audi"))
                .log().all();
    }

    @Test
    public void brandTestWithHttpClient() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://qauto.forstudy.space/api/cars/brands"))
                .build();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject responseBody = gson.fromJson(response.body(), JsonObject.class);

        String status = responseBody.get("status").getAsString();
        JsonArray data = responseBody.getAsJsonArray("data");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200, "Status code should be 200");
        softAssert.assertEquals(status, "ok", "Status should be ok");
        boolean isAudiFound = false;
        for (JsonElement element : data) {
            JsonObject brand = element.getAsJsonObject();
            int id = brand.get("id").getAsInt();
            String title = brand.get("title").getAsString();

            if (id == 1 && "Audi".equals(title)) {
                isAudiFound = true;
                break;
            }
        }
        softAssert.assertTrue(isAudiFound, "Response body should contain an object with id: 1 and tittle: Audi");
        softAssert.assertAll();

    }
}
