package tests;

import com.codeborne.selenide.Selenide;
import dataProviders.PanelInstructionsPageDataProvider;
import listeners.TestRunListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PanelInstructionsPage;
import pages.PanelPage;
import pages.QaForStudySpacePage;
import utils.InstructionNameHelper;

@Listeners(TestRunListener.class)
public class PanelInstructionsPageTest {
    private QaForStudySpacePage qaForStudySpacePage;
    private PanelPage panelPage;
    private PanelInstructionsPage panelInstructionsPage;

    @BeforeMethod
    public void setUp() {
        qaForStudySpacePage = QaForStudySpacePage.openPage();
        panelPage = new PanelPage();
        panelInstructionsPage = new PanelInstructionsPage();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
        qaForStudySpacePage = null;
        panelPage = null;
        panelInstructionsPage = null;
    }

    @Test(testName = "downloadInstructionsTest",
            description = "Downloading instructions of front windshield",
            dataProviderClass = PanelInstructionsPageDataProvider.class,
            dataProvider = "dateForLookForInstructionsForCars"

    )
    public void downloadInstructionsTest(String instructionName, String brandName, String modelName) {
        String expectedResult = InstructionNameHelper.createInstructionName(instructionName, brandName, modelName);

        qaForStudySpacePage
                .clickGuestLogInButton();

        String actualFileName = panelPage
                .clickOnInstructionsButton()
                .selectBrandOfCarInDropDownByName(brandName)
                .selectModelOfCarInDropDownByName(modelName)
                .clickSearchButton()
                .downloadInstructionByItsName(instructionName);

        Assert.assertEquals(actualFileName, expectedResult);
    }
}
