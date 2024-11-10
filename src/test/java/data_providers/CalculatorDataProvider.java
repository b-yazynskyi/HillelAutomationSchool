package data_providers;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {
    @DataProvider
    public Object[][] addCalculatorDataProvider() {
        return new Object[][] {
                {10, 5, 5},
                {8, 2, 6},
                {9000, 6000, 2000, 999, 1}
        };
    }

    @DataProvider
    public Object[][] subtractCalculatorDataProvider() {
        return new Object[][] {
                {5, 15, 10},
                {500, 1000, 200, 300},
                {1.87, 5, 3.13}
        };
    }
}
