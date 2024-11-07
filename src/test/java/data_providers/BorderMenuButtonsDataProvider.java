package data_providers;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;

public class BorderMenuButtonsDataProvider {
    @DataProvider
    public Object[][] borderMenuButtonNames() {
        var borderMenuButtonNamesList = new ArrayList<>(
                Arrays.asList("Garage", "Fuel expenses", "Instructions", "Log out")
        );
        return new Object[][]{
                new Object[]{borderMenuButtonNamesList}
        };
    }
}
