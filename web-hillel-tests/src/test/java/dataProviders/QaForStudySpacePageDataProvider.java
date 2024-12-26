package dataProviders;


import org.testng.annotations.DataProvider;

import java.util.Map;

public class QaForStudySpacePageDataProvider {
    @DataProvider
    public Object[] backGroundColorDataProvider() {
        return new Object[] {
                "#0275d8"
        };
    }

    @DataProvider
    public Object[] tittleOfVideoBlockDataProvider() {
        return new Object[] {
                "Hillel IT School | Учись ради мечты! - YouTube"
        };
    }

    @DataProvider
    public Object[][] emailAndPasswordsForSignIn() {
        return new Object[][] {
                {"test@hillel.ua", "1111"},
                {"test@hillel.ua", "1234"}
        };
    }

    @DataProvider
    public Object[][] socialNetworkNamesAndUrls() {
        Map<String, String> expectedLinks = Map.of(
                "facebook", "https://www.facebook.com/Hillel.IT.School",
                "telegram", "https://t.me/ithillel_kyiv",
                "youtube", "https://www.youtube.com/user/HillelITSchool",
                "instagram", "https://www.instagram.com/hillel_itschool/",
                "linkedin", "https://www.linkedin.com/school/ithillel/"
        );

        return expectedLinks.entrySet()
                .stream()
                .map(entry -> new Object[]{entry.getKey(), entry.getValue()})
                .toArray(Object[][]::new);
    }
}
