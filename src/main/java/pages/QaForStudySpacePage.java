package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.Color;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class QaForStudySpacePage {
    private final SelenideElement LOGO_PAGE = $x("//*[@class='header_left d-flex align-items-center']");
    private final SelenideElement SIGN_UP_BUTTON = $x("//*[@class='hero-descriptor_btn btn btn-primary']");

    @Step("checkIsLogoDisplayed")
    public boolean checkIsLogoDisplayed() {
        LOGO_PAGE.shouldBe(Condition.visible);

        return LOGO_PAGE.isDisplayed();
    }

    @Step("getBackGroundColorOfSignUp")
    public String getBackGroundColorOfSignUp() {
        SIGN_UP_BUTTON.shouldHave(Condition.cssValue("background-color",
                "rgba(2, 117, 216, 1)"));

        return Color.fromString(SIGN_UP_BUTTON.getCssValue("background-color")).asHex();
    }

    @Step("Open page")
    public static QaForStudySpacePage openPage() {
        open("");

        return new QaForStudySpacePage();
    }
}
