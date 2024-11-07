package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class QaAutoForStudyPage extends BasePage {
    private final SelenideElement GUEST_LOG_IN_BUTTON = $x("//button[@class='header-link -guest']");

    public PanelPage clickGuestLogInPage() {
        GUEST_LOG_IN_BUTTON.click();
        return page(PanelPage.class);
    }
}
