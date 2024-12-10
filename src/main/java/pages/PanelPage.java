package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Slf4j
public class PanelPage extends BasePage {
    private final SelenideElement INSTRUCTIONS_BUTTON = $x("//a[@routerLink='instructions']");

    @Step("Click on Instructions button")
    public PanelInstructionsPage clickOnInstructionsButton() {
        log.info("Clicking on Instruction button");
        INSTRUCTIONS_BUTTON.shouldBe(Condition.clickable).click();

        return new PanelInstructionsPage();
    }

    @Step("Open PanelPage")
    public static PanelPage openPage() {
        log.info("Opening PanelPage");
        open("/panel");

        return new PanelPage();
    }
}
