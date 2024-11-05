package pages;

import org.openqa.selenium.WebDriver;

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
        driver.get(BASE_URL + path);
    }
}
