package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Slf4j
public class PanelGaragePage {
    private final SelenideElement ADD_CAR_BUTTON = $x("//*[@class='btn btn-primary']");

    @Step("Click on Add car button")
    public void clickAddCarButton() {
        ADD_CAR_BUTTON.shouldBe(Condition.visible).click();
    }

    @Step("Open page")
    public PanelGaragePage openPage() {
        log.info("Opening panel Garage page");
        open("/panel/garage");

        return new PanelGaragePage();
    }
}
