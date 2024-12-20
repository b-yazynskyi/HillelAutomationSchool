package pages.qa_for_study_space_page_tests;

import com.codeborne.selenide.Selenide;
import dataProviders.QaForStudySpacePageDataProvider;
import io.qameta.allure.*;
import listeners.TestRunListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.QaForStudySpacePage;

@Listeners({TestRunListener.class})
@Feature("Tests for QaForStudySpace page")
public class QaForStudySpacePageTest extends BaseTest {
    private QaForStudySpacePage qaForStudySpacePage;

    @BeforeMethod
    public void initPages() {
        qaForStudySpacePage = QaForStudySpacePage.openPage();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
        qaForStudySpacePage = null;
    }

    @Test(testName = "IsLogoDisplayed", description = "Check either Logo displayed or not")
    public void logoDisplayedTest() {
        Assert.assertTrue(qaForStudySpacePage.checkIsLogoDisplayed(), "Logo does not displayed");
    }

    @Description("Test sign up background color")
    @Owner("Bohdan")
    @Link("https://lms.ithillel.ua/groups/667a91d512578b9e5119055f/homeworks/6745a1e991d73f851faf9590")
    @Severity(SeverityLevel.NORMAL)
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

    @Description("Test tittle of video in frame")
    @Owner("Bohdan")
    @Link("https://lms.ithillel.ua/groups/667a91d512578b9e5119055f/homeworks/6745a1e991d73f851faf9590")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "videoFrameTittleTest",
            description = "Check either tittle of video block correct or not",
            dataProviderClass = QaForStudySpacePageDataProvider.class,
            dataProvider = "tittleOfVideoBlockDataProvider"
    )
    public void videoFrameTittleTest(String expectedResult) {
        String actualResult = qaForStudySpacePage.getTittleOfVideoBlock();

        Assert.assertEquals(actualResult, expectedResult, "Title doesn’t equals to the expected result");
    }

    @Description("Test social network links by clicking and verifying url.")
    @Owner("Bohdan")
    @Link("https://lms.ithillel.ua/groups/667a91d512578b9e5119055f/homeworks/6745a1e991d73f851faf9590")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "socialNetworkUrlTest",
            description = "Check that social link url is correct",
            dataProviderClass = QaForStudySpacePageDataProvider.class,
            dataProvider = "socialNetworkNamesAndUrls"
    )
    public void socialNetworkUrlTest(String networkName, String expectedUrl) {
        String actualUrl = qaForStudySpacePage.clickOnSocialNetworkLink(networkName);

        Assert.assertTrue(actualUrl.contains(expectedUrl), "Incorrect url of Social network");
    }

    @Description("Test where test social networks icons in footer")
    @Owner("Bohdan")
    @Link("https://lms.ithillel.ua/groups/667a91d512578b9e5119055f/homeworks/6745a1e991d73f851faf9590")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "socialIconsInFooterTest",
            description = "Check that there is all social links in footer"
    )
    public void socialIconsInFooterTest() {
        Assert.assertTrue(qaForStudySpacePage.checkSocialLinksFromFooter(),
                "Social network block doesn’t contain 5 items");
    }

    @Description("Test where enter wrong email and password in sign in modal then check error message")
    @Owner("Bohdan")
    @Link("https://lms.ithillel.ua/groups/667a91d512578b9e5119055f/homeworks/6756c69b15846cebde08c45f")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "errorMessageOnModalTest",
            dataProviderClass = QaForStudySpacePageDataProvider.class,
            dataProvider = "emailAndPasswordsForSignIn",
            description = "Test where enter wrong email and password in sign in modal then check error message"
    )
    public void errorMessageOnModalTest(String email, String password) {
        String expectedResult = "Wrong email or password";

        String actualResult = qaForStudySpacePage.clickSignInButton()
                .enterDataToEmailInput(email)
                .enterDataToPasswordInput(password)
                .clickLoginButtonOnModal()
                .getErrorMessageOnModal();

        Assert.assertEquals(actualResult, expectedResult,
                "Error message text doesn't match with expected result");
    }
}
