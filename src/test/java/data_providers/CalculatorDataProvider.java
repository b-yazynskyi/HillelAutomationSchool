package data_providers;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {
    @DataProvider
    public static Object[][] addCalculatorDataProvider() {
        return new Object[][] {
                {10, 5, 5},
                {8, 2, 6},
                {9000, 6000, 2000, 999, 1}
        };
    }
}
