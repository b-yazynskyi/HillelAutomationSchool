package driver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.annotation.Nonnull;

public class WbDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        ChromeOptions options = getOptions();
        options.merge(capabilities);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }

    private ChromeOptions getOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");

        return chromeOptions;
    }
}
