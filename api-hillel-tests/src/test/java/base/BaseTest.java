package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.AppConfigUtils;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = AppConfigUtils.CONFIG.baseUri();
    }
}
