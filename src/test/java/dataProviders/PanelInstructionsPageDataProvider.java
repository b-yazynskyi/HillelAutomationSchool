package dataProviders;

import org.testng.annotations.DataProvider;


public class PanelInstructionsPageDataProvider {
    @DataProvider
    public Object[][] dateForLookForInstructionsForCars() {
        return new Object[][] {
                {"Front windshield wipers on", "Audi", "TT"},
                {"Front brake discs on", "BMW", "X5"},
                {"Engine oil and filter on", "Fiat", "Palio"},
                {"Front strut mount on", "Ford", "Fiesta"}
        };
    };
}
