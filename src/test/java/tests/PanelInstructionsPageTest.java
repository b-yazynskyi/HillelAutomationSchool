package tests;

import com.codeborne.selenide.Selenide;
import listeners.TestRunListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PanelInstructionsPage;
import pages.PanelPage;
import pages.QaForStudySpacePage;

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
            description = "Downloading instructions of front windshield"
    )
    public void downloadInstructionsTest() {
        qaForStudySpacePage
                .clickGuestLogInButton();
        String actualFileName = panelPage
                .clickOnInstructionsButton()
                .clickDownloadFrontWindshield();

        Assert.assertEquals(actualFileName, "Front_20windshield_20wipers_20on_20Audi_20TT.pdf");
    }
}
