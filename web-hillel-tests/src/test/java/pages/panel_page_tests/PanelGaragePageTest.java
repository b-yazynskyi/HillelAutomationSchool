package pages.panel_page_tests;

import com.codeborne.selenide.Selenide;
import dataProviders.PanelGaragePageDataProvider;
import io.qameta.allure.*;
import listeners.TestRunListener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.BaseTest;

import pages.PanelGaragePage;
import pages.QaForStudySpacePage;

import java.time.LocalDate;

@Listeners({TestRunListener.class})
@Feature("Test for Panel Garage page")
public class PanelGaragePageTest extends BaseTest {

    private QaForStudySpacePage qaForStudySpacePage;
    private PanelGaragePage panelGaragePage;

    @BeforeMethod
    public void initPages() {
        qaForStudySpacePage = QaForStudySpacePage.openPage();
        panelGaragePage = new PanelGaragePage();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
        qaForStudySpacePage = null;
        panelGaragePage = null;
    }

    @Description("Test where adding car to garage and then assert that car name, logo etc.")
    @Owner("Bohdan")
    @Link("https://lms.ithillel.ua/groups/667a91d512578b9e5119055f/homeworks/6745a1e991d73f851faf9590")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "addCarAsGuestUserTest",
            description = "Testing flow from log in as guest to adding new car",
            dataProviderClass = PanelGaragePageDataProvider.class,
            dataProvider = "dataForAddNewCarIntoGarage",
            groups = "Adding car to garage group"
    )
    public void addCarAsGuestUserTest(String brandName, String modelName, String millageNumber, String imageUrlName) {
        qaForStudySpacePage
                .clickGuestLogInButton()
                .clickAddCarButton()
                .selectBrandInModal(brandName)
                .selectModelInModal(modelName)
                .enterValueToMillageField(millageNumber)
                .clickAddButtonInModal();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(panelGaragePage.getCarNameFromGarage(), brandName + " " + modelName);
        softAssert.assertEquals(panelGaragePage.getDateFromMileageUpdate(), LocalDate.now());
        softAssert.assertEquals(panelGaragePage.getInfoFromMileageInput(),
                Integer.valueOf(millageNumber));
        softAssert.assertTrue(panelGaragePage.checkLogoVisibility());
        softAssert.assertEquals(panelGaragePage.getUrlOfLogoEnds(), imageUrlName, "Url name isn't correct");
        softAssert.assertAll();
    }

}
