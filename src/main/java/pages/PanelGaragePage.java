package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Slf4j
public class PanelGaragePage extends PanelPage {
    private final SelenideElement ADD_CAR_BUTTON = $x("//*[@class='btn btn-primary']");
    private final SelenideElement CAR_BRAND_SELECT = $x("//select[@id='addCarBrand']");
    private final SelenideElement CAR_MODEL_SELECT = $x("//select[@id='addCarModel']");
    private final SelenideElement CAR_MILEAGE_FIELD = $x("//input[@id='addCarMileage']");
    private final SelenideElement ADD_MODAL_BUTTON
            = $x("//div[@class='modal-footer d-flex justify-content-end']" +
            "/button[@class='btn btn-primary']");
    private final SelenideElement CAR_NAME_FIELD = $x("//p[@class='car_name h2']");
    private final SelenideElement MILEAGE_DATE_FIELD = $x("//p[@class='car_update-mileage']");
    private final SelenideElement MILEAGE_INPUT = $x("//input[@name='miles']");
    private final SelenideElement CAR_LOGO = $x("//img[@class='car-logo_img']");
    private final SelenideElement EDIT_CAR_BLOCK_BUTTON = $x("//button[@class='car_edit btn btn-edit']");
    private final SelenideElement REMOVE_CAR_BUTTON = $x("//button[@class='btn btn-outline-danger']");

    @Step("Select brand in modal window")
    public PanelGaragePage selectBrandInModal(String brandName) {
        log.info("Select {} brand in modal window", brandName);
        CAR_BRAND_SELECT.shouldBe(Condition.visible).selectOptionContainingText(brandName);

        return this;
    }

    @Step("Select model in modal window")
    public PanelGaragePage selectModelInModal(String modelName) {
        log.info("Select {} model in modal window", modelName);
        CAR_MODEL_SELECT.shouldBe(Condition.visible).selectOption(modelName);

        return this;
    }

    @Step("Enter millage in modal window")
    public PanelGaragePage enterValueToMillageField(String millageNumber) {
        log.info("Enter {} millage number into millage field", millageNumber);
        CAR_MILEAGE_FIELD.shouldBe(Condition.visible).sendKeys(millageNumber);

        return this;
    }

    @Step("Click add button in modal window")
    public void clickAddButtonInModal() {
        log.info("Click on add button in modal window");
        ADD_MODAL_BUTTON.shouldBe(Condition.clickable).click();
    }

    @Step("Click on Add car button")
    public PanelGaragePage clickAddCarButton() {
        log.info("Clicking add car button");
        ADD_CAR_BUTTON.shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Click on edit button")
    public PanelGaragePage clickOnEditButton() {
        log.info("Clicking on edit button");
        EDIT_CAR_BLOCK_BUTTON.shouldBe(Condition.clickable).click();

        return this;
    }

    @Step("Click remove car button")
    public PanelGaragePage clickRemoveCarButton() {
        log.info("Clicking on remove car button");
        REMOVE_CAR_BUTTON.shouldBe(Condition.clickable).click();

        return this;
    }

    @Step("Get car name from garage")
    public String getCarNameFromGarage() {
        log.info("Getting car name from garage");
        return CAR_NAME_FIELD.shouldBe(Condition.visible).getText();
    }

    @Step("Get date from mileage update")
    public LocalDate getDateFromMileageUpdate() {
        log.info("Getting date from mileage update");
        String[] infoFromDate = MILEAGE_DATE_FIELD.shouldBe(Condition.visible).getText().split("•");
        String dateFromMileageField = infoFromDate[1].trim();
        log.info("Date from mileage field is {}", dateFromMileageField);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dateFromMileageField, formatter);
        log.info("Date after parsing: {}", date);

        return date;
    }

    @Step("Get info from mileage input")
    public Integer getInfoFromMileageInput() {
        log.info("Getting info from mileage input");
        return Integer.parseInt(Objects.requireNonNull(MILEAGE_INPUT.shouldBe(Condition.visible).getValue()));
    }

    @Step("Check logo visibility of car")
    public boolean checkLogoVisibility() {
        log.info("Checking logo visibility");
        CAR_LOGO.shouldBe(Condition.image);

        return true;
    }

    @Step("Get the url end of logo")
    public String getUrlOfLogoEnds() {
        log.info("Getting the end of URL in src for logo");
        String[] temp = new String[0];

        String srcUrlOfLogo = CAR_LOGO.shouldBe(Condition.visible).getAttribute("src");

        if (srcUrlOfLogo != null) {
            temp = srcUrlOfLogo.split("/");
        }

        return temp[temp.length -1];
    }

    @Step("Open page")
    public static PanelGaragePage openPage() {
        log.info("Opening panel Garage page");
        open("/panel/garage");

        return new PanelGaragePage();
    }
}
