package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static pages.PanelPageSelectors.*;

public class PanelPage extends BasePage {
    private static final String URL = "/panel";
    private List<WebElement> borderMenuButtons;

    public PanelPage(WebDriver driver) {
        super(driver);
    }

    /* До цього робив варіант щоб під кожну кнопку був метод який витягає текст по цій кнопці,
    але вирішив зробити 1 уніфікований метод так як не має потреби у подальшій взаємодії з кожною кнопкою окремо
    */
    public List<String> getBorderMenuButtonsText() {
        if (Objects.isNull(borderMenuButtons)) {
            borderMenuButtons = getDriver().findElements(By.xpath(BORDER_MENU_BUTTONS));
        }

        return borderMenuButtons.stream().filter(Objects::nonNull).map(WebElement::getText).toList();
    }

    public PanelPage openPage() {
        super.openPage(URL);
        return this;
    }

}
