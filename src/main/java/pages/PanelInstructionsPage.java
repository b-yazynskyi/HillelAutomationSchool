package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PanelInstructionsPage extends PanelPage {
    private final SelenideElement DOWNLOAD_FRONT_WINDSHIELD
            = $x("//p[contains(text(), 'Front windshield wipers on')]/following-sibling::a");

    @Step("Download Front windshield wipers")
    public String clickDownloadFrontWindshield() {
        File file = DOWNLOAD_FRONT_WINDSHIELD.shouldBe(Condition.clickable).download();

        return file.getName();
    }

    @Step("Open PanelInstructionsPage")
    public static PanelInstructionsPage openPage() {
        open("/panel/instructions");

        return new PanelInstructionsPage();
    }
}
