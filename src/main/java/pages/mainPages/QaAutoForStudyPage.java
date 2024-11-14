package pages.mainPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.Color;
import pages.basePage.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class QaAutoForStudyPage extends BasePage {
    private final SelenideElement LOGO = $x("//*[@class='header_logo']");
    private final SelenideElement SIGN_UP = $x("//*[@class='hero-descriptor_btn btn btn-primary']");

    @Step("Check is logo on site visible")
    public boolean isLogoVisible() {
        return LOGO.isDisplayed();
    }

    @Step("Getting background color of Sign Up button")
    public String getBackGroundColorForSignUp() {
        String backGroundColor = SIGN_UP.getCssValue("background-color");
        return Color.fromString(backGroundColor).asHex();
    }

}
