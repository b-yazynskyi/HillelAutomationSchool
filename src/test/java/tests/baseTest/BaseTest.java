package tests.baseTest;

import com.codeborne.selenide.Configuration;
import driver.WbDriver;
import org.testng.annotations.BeforeClass;
import utils.AppConstants;

import static com.codeborne.selenide.Configuration.browser;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        browser = WbDriver.class.getName();
        Configuration.headless = AppConstants.HEADLESS_APP_MODE;
    }
}
