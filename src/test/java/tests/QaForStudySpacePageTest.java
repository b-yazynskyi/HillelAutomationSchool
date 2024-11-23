package tests;

import dataProviders.QaForStudySpacePageDataProvider;
import io.qameta.allure.Feature;
import listeners.TestRunListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.QaForStudySpacePage;

@Listeners({TestRunListener.class})
@Feature("Tests for QaForStudySpace page")
public class QaForStudySpacePageTest {
    private QaForStudySpacePage qaForStudySpacePage;

    @BeforeMethod
    public void initPages() {
        qaForStudySpacePage = QaForStudySpacePage.openPage();
    }

    @AfterMethod
    public void tearDown() {
        qaForStudySpacePage = null;
    }

    @Test(testName = "IsLogoDisplayed", description = "Check either Logo displayed or not")
    public void logoDisplayedTest() {
        Assert.assertTrue(qaForStudySpacePage.checkIsLogoDisplayed(), "Logo does not displayed");
    }

    @Test(testName = "SignUpButtonBackgroundColor",
            description = "Check either background color of SignUp button proper or not",
            dataProviderClass = QaForStudySpacePageDataProvider.class,
            dataProvider = "backGroundColorDataProvider"
    )
    public void signUpButtonBackgroundColorTest(String expectedBackGroundColor) {
        String actualBackGroundColor = qaForStudySpacePage.getBackGroundColorOfSignUp();

        Assert.assertEquals(actualBackGroundColor, expectedBackGroundColor,
                "Background color of Sign up button is incorrect");
    }
}
