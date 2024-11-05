package pages;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public abstract class BasePage implements Page{
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    protected void openPage(String path) {
        if (Objects.isNull(path)) {
            driver.get(BASE_URL);
        } else {
            driver.get(BASE_URL + path);
        }
    }
}
