package tests;

import dataProviders.PanelGaragePageDataProvider;
import io.qameta.allure.Feature;
import listeners.TestRunListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PanelGaragePage;
import pages.QaForStudySpacePage;

@Listeners({TestRunListener.class})
@Feature("Test for Panel Garage page")
public class PanelGaragePageTest {
    private QaForStudySpacePage qaForStudySpacePage;
    private PanelGaragePage panelGaragePage;

    @BeforeMethod
    public void initPages() {
        qaForStudySpacePage = QaForStudySpacePage.openPage();
        panelGaragePage = PanelGaragePage.openPage();
    }

    @AfterMethod
    public void tearDown() {
        qaForStudySpacePage = null;
        panelGaragePage = null;
    }

    @Test(testName = "addCarAsGuestUserTest",
            description = "Testing flow from log in as guest to adding new car",
            dataProviderClass = PanelGaragePageDataProvider.class,
            dataProvider = "dataForAddNewCarIntoGarage"
    )
    public void addCarAsGuestUserTest(String brandName, String modelName, String millageNumber) {
        qaForStudySpacePage
                .clickGuestLogInButton()
                .clickAddCarButton()
                .selectBrandInModal(brandName)
                .selectModelInModal(modelName)
                .enterValueToMillageField(millageNumber)
                .clickAddButtonInModal();

    }
}
