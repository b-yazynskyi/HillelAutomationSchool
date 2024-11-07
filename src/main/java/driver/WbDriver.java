package driver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.AppConstants;

import javax.annotation.Nonnull;
import java.time.Duration;

public class WbDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        ChromeOptions options = getChromeOptions();
        options.merge(capabilities);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

        if (AppConstants.HEADLESS_PROP_MODE) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("----window-size=1920,1080");
        }

        return chromeOptions;
    }
}
