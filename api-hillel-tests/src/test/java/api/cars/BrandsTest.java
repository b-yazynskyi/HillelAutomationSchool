package api.cars;

import base.BaseTest;
import clients.CarClient;
import com.google.gson.*;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import responses.GetCarBrandsResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

import static utils.JsonUtils.fromJson;

@Feature("Route GET /cars/brands")
public class BrandsTest extends BaseTest {
    private CarClient carClient;

    @BeforeClass
    public void initClients() {
        carClient = new CarClient();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Assert that GET request to brand returns 200 and brand Audi with id: 1")
    @Owner("Bohdan Yazynskyi")
    @Test(testName = "brandTestWithRestAssured",
            description = "Assert that GET request to brand returns 200 and brand Audi with id: 1"
    )
    public void brandTestWithRestAssured() {
        var response = carClient.getCarBrands();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200, "Status code should be 200");

        GetCarBrandsResponse getCarBrandsResponse = fromJson(response.getBody().asString(), GetCarBrandsResponse.class);
        var carBrandsList = getCarBrandsResponse.getData();

        softAssert.assertTrue(carBrandsList.stream().anyMatch(elem -> elem.getId() == 1 && Objects.equals(elem.getTitle(), "Audi")));
        softAssert.assertAll();
    }

    // Ugly implementations, just to make homework :)
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
