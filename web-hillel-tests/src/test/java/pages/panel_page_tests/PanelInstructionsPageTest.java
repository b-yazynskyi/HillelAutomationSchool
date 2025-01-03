package pages.panel_page_tests;

import com.codeborne.selenide.Selenide;
import dataProviders.PanelInstructionsPageDataProvider;
import io.qameta.allure.*;
import listeners.TestRunListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.BaseTest;
import pages.PanelInstructionsPage;
import pages.PanelPage;
import pages.QaForStudySpacePage;
import utils.InstructionNameHelper;

import java.util.List;

@Feature("Tests for PanelInstructionsPage")
@Listeners(TestRunListener.class)
public class PanelInstructionsPageTest extends BaseTest {
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

    @Description("Test where downloading instruction and then validate name of that file")
    @Owner("Bohdan")
    @Link("https://lms.ithillel.ua/groups/667a91d512578b9e5119055f/homeworks/6745a1e991d73f851faf9590")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "downloadInstructionsTest",
            description = "Downloading instructions of front windshield",
            dataProviderClass = PanelInstructionsPageDataProvider.class,
            dataProvider = "dateForLookForInstructionsForCars",
            dependsOnGroups = {"unit-tests"}
    )
    public void downloadInstructionsTest(String instructionName, String brandName, String modelName) {
        String expectedResult = InstructionNameHelper.createInstructionName(instructionName, brandName, modelName);

        qaForStudySpacePage
                .clickGuestLogInButton();

        String actualFileName = panelPage
                .clickOnInstructionsButton()
                .clickOnSelectBrandOfCar()
                .selectBrandOfCarInDropDownByName(brandName)
                .selectModelOfCarInDropDownByName(modelName)
                .clickSearchButton()
                .downloadInstructionByItsName(instructionName);

        Assert.assertEquals(actualFileName, expectedResult);
    }

    @Description("Test where writing all car brand names from dropdown to txt file")
    @Owner("Bohdan")
    @Link("https://lms.ithillel.ua/groups/667a91d512578b9e5119055f/homeworks/6745a1e991d73f851faf9590")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "writeAllCarBrandNamesTest",
            description = "This test writing to file all car brand names" +
                    "and then verify that they matched with expected result",
            dataProviderClass = PanelInstructionsPageDataProvider.class,
            dataProvider = "dateForCarBrandNames",
            dependsOnGroups = {"unit-tests"}
    )
    public void writeAllCarBrandNamesTest(List<String> expectedResult) {
        qaForStudySpacePage.clickGuestLogInButton();

        String actualResult = panelPage
                .clickOnInstructionsButton()
                .clickOnSelectBrandOfCar()
                .createFileWithCarBrandNames();

        String expectedData = String.join(System.lineSeparator(), expectedResult);

        Assert.assertEquals(actualResult, expectedData);
    }
}
