package dataProviders;

import org.testng.annotations.DataProvider;

import java.util.Arrays;


public class PanelInstructionsPageDataProvider {
    @DataProvider
    public Object[][] dateForLookForInstructionsForCars() {
        return new Object[][] {
                {"Front windshield wipers on", "Audi", "TT"},
                {"Front brake discs on", "BMW", "X5"},
                {"Engine oil and filter on", "Fiat", "Palio"},
                {"Front strut mount on", "Ford", "Fiesta"}
        };
    }

    @DataProvider
    public Object[] dateForCarBrandNames() {
        return new Object[] {Arrays.asList("Audi", "BMW", "Ford", "Porsche", "Fiat")};
    }
}
