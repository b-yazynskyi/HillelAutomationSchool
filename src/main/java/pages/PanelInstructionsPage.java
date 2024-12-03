package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class PanelInstructionsPage extends PanelPage {
    private final SelenideElement BRAND_SELECT_BUTTON = $x("//button[@id='brandSelectDropdown']");
    private final ElementsCollection DROPDOWN_BRAND_VALUES
            = $$x("//li[contains(@class,'dropdown-item btn btn-link brand-select-dropdown_item')]");
    private final SelenideElement SEARCH_BUTTON
            = $x("//button[@class='instructions-search-controls_search btn btn-primary']");
    private final SelenideElement MODEL_SELECT_BUTTON = $x("//button[@id='modelSelectDropdown']");
    private final ElementsCollection DROPDOWN_SELECT_VALUES
            = $$x("//li[contains(@class,'dropdown-item btn btn-link model-select-dropdown_item')]");
    private final ElementsCollection INSTRUCTIONS_BY_DESCRIPTION
            = $$x("//p[@class='instruction-link_description']");


    @Step("Select brand of car in dropdown")
    public PanelInstructionsPage selectBrandOfCarInDropDownByName(String brandName) {
        log.info("Selecting brand of car in dropdown with name: {}", brandName);
        BRAND_SELECT_BUTTON.shouldBe(Condition.clickable).click();
        for (SelenideElement element : DROPDOWN_BRAND_VALUES) {
            if (element.getText().equals(brandName)
                    && !Objects.requireNonNull(element.getAttribute("class")).contains("disabled")) {
                log.info("Clicking on brand: {}", element.getText());
                element.click();
            }
        }

        return this;
    }

    @Step("Select model of car in dropdown")
    public PanelInstructionsPage selectModelOfCarInDropDownByName(String modelName) {
        log.info("Selecting model of car in dropdown with name: {}", modelName);
        MODEL_SELECT_BUTTON.shouldBe(Condition.clickable).click();
        for (SelenideElement element : DROPDOWN_SELECT_VALUES) {
            if (element.getText().equals(modelName)
                    && !Objects.requireNonNull(element.getAttribute("class")).contains("disabled")) {
                log.info("Clicking on model: {}", element.getText());
                element.click();
            }
        }

        return this;
    }

    @Step("Click search button")
    public PanelInstructionsPage clickSearchButton() {
        log.info("Clicking search button");
        SEARCH_BUTTON.shouldBe(Condition.clickable).click();

        return this;
    }

    @Step("Download instruction by it's name")
    public String downloadInstructionByItsName(String instructionName) {
        log.info("Start downloading file");
        // Need to think how to replace this
        Selenide.sleep(1000);

        log.info("Looking for instruction with name: {}", instructionName);
        SelenideElement instruction =
                INSTRUCTIONS_BY_DESCRIPTION
                        .stream()
                        .filter(x -> x.getText().contains(instructionName))
                        .findFirst()
                        .orElseThrow(() -> new NoSuchElementException("No link found with:" + instructionName));

        SelenideElement linkToDownloadInstruction = instruction.$x("following-sibling::a");


        log.info("Downloading file");
        File file = linkToDownloadInstruction.shouldBe(Condition.appear).download();

        return file.getName();
    }

    @Step("Open PanelInstructionsPage")
    public static PanelInstructionsPage openPage() {
        log.info("Opening PanelInstructionsPage");
        open("/panel/instructions");

        return new PanelInstructionsPage();
    }
}
