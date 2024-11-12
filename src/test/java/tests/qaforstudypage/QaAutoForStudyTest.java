package tests.qaforstudypage;

import data_providers.QaForStudyDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mainPages.QaAutoForStudyPage;
import tests.baseTest.BaseTest;

import java.util.Objects;

import static pages.basePage.BasePage.navigateToPage;
import static utils.AppConstants.BASE_URL;

public class QaAutoForStudyTest extends BaseTest {
    private QaAutoForStudyPage qaAutoForStudyPage;

    @BeforeClass
    public void initiatePages() {
        qaAutoForStudyPage = new QaAutoForStudyPage();
    }

    @Test(priority = 1, description = "Checking whether Logo visible on page or not")
    public void checkLogoIsVisibleTest() {
        navigateToPage(BASE_URL);

        boolean isLogoVisible = qaAutoForStudyPage.isLogoVisible();

        if (isLogoVisible) {
            System.out.println("Logo displayed");
        } else {
            System.out.println("Logo does not displayed");
        }

        Assert.assertTrue(isLogoVisible);
    }

    @Test(priority = 2, description = "Check the background color of Sign Up button",
            dataProviderClass = QaForStudyDataProvider.class,
            dataProvider = "backGroundColorDataProvider"
    )
    public void checkBackGroundColorSignUpButtonTest(String expectedBackGroundColor) {
        navigateToPage(BASE_URL);

        String backGroundColor = qaAutoForStudyPage.getBackGroundColorForSignUp();

        boolean isBackGroundColorEquals = Objects.equals(backGroundColor, expectedBackGroundColor);

        if (isBackGroundColorEquals) {
            System.out.println("Background color of Sign up button is correct");
        } else {
            System.out.println("Background color of Sign up button is incorrect");
        }

        Assert.assertTrue(isBackGroundColorEquals);
    }
}

