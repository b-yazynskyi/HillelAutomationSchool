package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.Color;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class QaForStudySpacePage {
    private final SelenideElement LOGO_PAGE = $x("//*[@class='header_left d-flex align-items-center']");
    private final SelenideElement SIGN_UP_BUTTON = $x("//*[@class='hero-descriptor_btn btn btn-primary']");

    public boolean checkIsLogoDisplayed() {
        LOGO_PAGE.shouldBe(Condition.visible);

        return LOGO_PAGE.isDisplayed();
    }

    public String getBackGroundColorOfSignUp() {
        SIGN_UP_BUTTON.shouldHave(Condition.cssValue("background-color",
                "rgba(2, 117, 216, 1)"));

        return Color.fromString(SIGN_UP_BUTTON.getCssValue("background-color")).asHex();
    }

    public static QaForStudySpacePage openPage() {
        open("");

        return new QaForStudySpacePage();
    }
}
