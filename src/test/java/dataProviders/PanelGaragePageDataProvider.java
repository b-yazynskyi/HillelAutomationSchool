package dataProviders;

import org.testng.annotations.DataProvider;

public class PanelGaragePageDataProvider {
    @DataProvider
    public Object[][] dataForAddNewCarIntoGarage() {
        return new Object[][] {
                {"Audi", "TT", "20"},
                {"BMW", "3", "90"},
                {"Ford", "Fiesta", "1"},
                {"Porsche", "911", "45"}
        };
    }
}
