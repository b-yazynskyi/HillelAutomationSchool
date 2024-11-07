package base;

import com.codeborne.selenide.Configuration;
import driver.WbDriver;
import org.testng.annotations.BeforeClass;
import utils.AppConstants;

public class BaseTest {
    @BeforeClass
    public void setUp() {
        Configuration.browser = WbDriver.class.getName();
        Configuration.headless = AppConstants.HEADLESS_PROP_MODE;
    }
}
