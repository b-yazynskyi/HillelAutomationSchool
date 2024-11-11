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

    @DataProvider
    public Object[][] multiplyCalculatorDataProvider() {
        return new Object[][] {
                {20, 10, 2},
                {1000, 5, 200},
                {2147483647, 536870911.75, 2, 2}
        };
    }

    @DataProvider
    public Object[][] divideCalculatorDataProvider() {
        return new Object[][] {
                {20, 40, 2},
                {232, 464, 2},
                {350, 36750, 15, 7}
        };
    }

    @DataProvider
    public Object[][] zeroDivisionCalculatorDataProvider() {
        return new Object[][] {
                {15, 0}
        };
    }
}
