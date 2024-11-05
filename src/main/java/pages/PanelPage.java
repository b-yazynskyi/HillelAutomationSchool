package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.util.Objects;

import static pages.PanelPageSelectors.GARAGE_BUTTON;

public class PanelPage extends BasePage{
    private static final String URL = "/panel";
    private WebElement garageButton;
    private WebElement fuelExpensesButton;
    private WebElement instructionsButton;

    public PanelPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfGarageButton() {
        if (Objects.isNull(garageButton)) {
            garageButton = getDriver().findElement(By.xpath(GARAGE_BUTTON));
        }

        return garageButton.getText();
    }

    public void openPage() {
        super.openPage(URL);
    }

}
