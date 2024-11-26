package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Slf4j
public class PanelGaragePage extends PanelPage {
    private final SelenideElement ADD_CAR_BUTTON = $x("//*[@class='btn btn-primary']");
    private final SelenideElement CAR_BRAND_SELECT = $x("//select[@id='addCarBrand']");
    private final SelenideElement CAR_MODEL_SELECT = $x("//select[@id='addCarModel']");
    private final SelenideElement CAR_MILEAGE_FIELD = $x("//select[@id='addCarMileage']");
    private final SelenideElement ADD_MODAL_BUTTON
            = $x("//div[@class='modal-footer d-flex justify-content-end']" +
            "/button[@class='btn btn-primary']");
    private final SelenideElement CAR_NAME_FIELD = $x("//p[@class='car_name h2']");
    private final SelenideElement MILEAGE_DATE_FIELD = $x("//p[@class='car_update-mileage']");
    private final SelenideElement MILEAGE_INPUT = $x("//input[@name='miles']");
    private final SelenideElement CAR_LOGO = $x("//img[@class='car-logo_img']");

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
        ADD_CAR_BUTTON.shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Open page")
    public static PanelGaragePage openPage() {
        log.info("Opening panel Garage page");
        open("/panel/garage");

        return new PanelGaragePage();
    }
}
