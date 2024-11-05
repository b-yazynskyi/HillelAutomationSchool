package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class MainPage extends BasePage{
    private WebElement guestLogInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public PanelPage clickGuestLogInButton() {
        if (Objects.isNull(guestLogInButton)) {
            guestLogInButton = getDriver().findElement(By.xpath(GUEST_LOG_IN_BUTTON));
        }

        guestLogInButton.click();
        return new PanelPage(getDriver());
    }


}
