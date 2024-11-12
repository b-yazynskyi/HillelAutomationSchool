package pages.mainPages;

import com.codeborne.selenide.SelenideElement;
import pages.basePage.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class QaAutoForStudyPage extends BasePage {
    private final SelenideElement LOGO = $x("//*[@class='header_logo']");
    private final SelenideElement SIGN_UP = $x("//*[@class='hero-descriptor_btn btn btn-primary']");

    public boolean isLogoVisible() {
        return LOGO.isDisplayed();
    }

    public String getBackGroundColorForSignUp() {
        return SIGN_UP.getAttribute("background-color");
    }

}
