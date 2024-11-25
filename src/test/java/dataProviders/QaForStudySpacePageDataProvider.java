package dataProviders;


import org.testng.annotations.DataProvider;

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
}
