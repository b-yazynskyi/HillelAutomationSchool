package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Slf4j
public class QaForStudySpacePage {
    private final SelenideElement LOGO_PAGE = $x("//*[@class='header_left d-flex align-items-center']");
    private final SelenideElement SIGN_UP_BUTTON
            = $x("//*[@class='hero-descriptor_btn btn btn-primary']");
    private final SelenideElement IFRAME_BLOCK = $x("//*[@class='hero-video_frame']");
    private final SelenideElement VIDEO_BLOCK_TITTLE
            = $x("//*[@class='ytp-title-link yt-uix-sessionlink']");
    private final ElementsCollection SOCIAL_LINKS_IN_FOOTER = $$x("//*[@class='socials_link']");
    private final SelenideElement SOCIAL_LINKS_BLOCK_IN_FOOTER
            = $x("//div[@class='contacts_socials socials']");
    private final SelenideElement GUEST_LOG_IN_BUTTON = $x("//*[@class='header-link -guest']");

    @Step("Check is logo displayed")
    public boolean checkIsLogoDisplayed() {
        log.info("Checking is logo displayed");
        LOGO_PAGE.shouldBe(Condition.visible);

        return LOGO_PAGE.isDisplayed();
    }

    @Step("Get background color of SignUp button")
    public String getBackGroundColorOfSignUp() {
        log.info("Getting background color of Sign Up button");
        SIGN_UP_BUTTON.shouldHave(Condition.cssValue("background-color",
                "rgba(2, 117, 216, 1)"));

        return Color.fromString(SIGN_UP_BUTTON.getCssValue("background-color")).asHex();
    }

    @Step("Get tittle of video block")
    public String getTittleOfVideoBlock() {
        log.info("Getting tittle of video block");
        Selenide.switchTo().frame(IFRAME_BLOCK);
        VIDEO_BLOCK_TITTLE.shouldHave(Condition.exactText("Hillel IT School | Учись ради мечты! - YouTube"));

        return VIDEO_BLOCK_TITTLE.text();
    }

    @Step("Get social links from footer")
    public boolean checkSocialLinksFromFooter() {
        log.info("Getting social links from footer");
        SOCIAL_LINKS_IN_FOOTER.shouldHave(size(5));

        // Will return true in case exist all links
        return true;
    }

    @Step("Click on social network link by it's name")
    public String clickOnSocialNetworkLink(String socialNetworkName) {
        log.info("Validating social network link: {}", socialNetworkName);

        SelenideElement socialLink = SOCIAL_LINKS_BLOCK_IN_FOOTER
                .$x(".//a[contains(@class, 'socials_link')]" +
                        "/span[contains(@class, 'icon-" + socialNetworkName + "')]")
                .shouldBe(Condition.visible);

        socialLink.shouldBe(Condition.visible).click();
        Selenide.switchTo().window(1);

        String actualUrl = getWebDriver().getCurrentUrl();

        log.info("Actual URL after clicking link is {}", actualUrl);

        Selenide.closeWindow();
        Selenide.switchTo().window(0);

        return actualUrl;
    }

    @Step("Click Guest log in button")
    public PanelGaragePage clickGuestLogInButton() {
        GUEST_LOG_IN_BUTTON.shouldBe(Condition.visible).click();

        Assert.assertEquals(getWebDriver().getCurrentUrl(), "https://qauto.forstudy.space/panel/garage");

        return new PanelGaragePage();
    }

    @Step("Open page")
    public static QaForStudySpacePage openPage() {
        log.info("Opening QaForStudySpacePage");
        open("");

        return new QaForStudySpacePage();
    }
}
