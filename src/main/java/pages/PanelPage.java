package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static pages.PanelPageSelectors.*;

public class PanelPage extends BasePage{
    private static final String URL = "/panel";
    private WebElement garageButton;
    private WebElement fuelExpensesButton;
    private WebElement instructionsButton;
    private WebElement logOutButton;

    public PanelPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfGarageButton() {
        if (Objects.isNull(garageButton)) {
            garageButton = getDriver().findElement(By.xpath(GARAGE_BUTTON));
        }

        return garageButton.getText();
    }

    public String getTextOfFuelExpensesButton() {
        if (Objects.isNull(fuelExpensesButton)) {
            fuelExpensesButton = getDriver().findElement(By.xpath(FUEL_EXPENSES_BUTTON));
        }

        return fuelExpensesButton.getText();
    }

    public String getTextOfInstructionsButton() {
        if (Objects.isNull(instructionsButton)) {
            instructionsButton = getDriver().findElement(By.xpath(INSTRUCTIONS_BUTTON));
        }

        return instructionsButton.getText();
    }

    public String getTextOfLogOutButton() {
        if (Objects.isNull(logOutButton)) {
            logOutButton = getDriver().findElement(By.xpath(LOG_OUT_BUTTON));
        }

        return logOutButton.getText();
    }

    public PanelPage openPage() {
        super.openPage(URL);
        return this;
    }

}
