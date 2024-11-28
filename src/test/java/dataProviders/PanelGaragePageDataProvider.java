package dataProviders;

import org.testng.annotations.DataProvider;

public class PanelGaragePageDataProvider {
    @DataProvider
    public Object[][] dataForAddNewCarIntoGarage() {
        return new Object[][] {
                {"Audi", "TT", "20", "audi.png"},
                {"BMW", "3", "90", "bmw.png"},
                {"Ford", "Fiesta", "1", "ford.png"},
                {"Porsche", "911", "45", "porsche.png"}
        };
    }
}
