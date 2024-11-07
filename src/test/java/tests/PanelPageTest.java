package tests;

import base.BaseTest;
import data_providers.BorderMenuButtonsDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PanelPage;
import pages.QaAutoForStudyPage;

import java.util.List;

import static pages.BasePage.navigateToPage;
import static utils.AppConstants.BASE_URL;

public class PanelPageTest extends BaseTest {

    private QaAutoForStudyPage qaAutoForStudyPage;
    private PanelPage panelPage;

    @BeforeTest
    public void initPages() {
        qaAutoForStudyPage = new QaAutoForStudyPage();
        panelPage = new PanelPage();
    }

    @Test(priority = 1, dataProvider = "borderMenuButtonNames",
            dataProviderClass = BorderMenuButtonsDataProvider.class,
            description = "Getting text from border menu buttons " +
                    "and verify that text is the same."
    )
    public void checkButtonNamesMatched(List<String> buttonNamesList) {
        navigateToPage(BASE_URL);

       var buttonNames = qaAutoForStudyPage
                .clickGuestLogInPage()
                .getTextOfBorderMenuButtons();

        Assert.assertEqualsNoOrder(buttonNames, buttonNamesList, "Expected: "
                        + buttonNamesList + " || but was: " + buttonNames
                );
    }
}
