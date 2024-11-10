package tests;

import data_providers.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Calculator;

public class CalculatorTest extends BaseTest {
    private Calculator calculator;

    @BeforeClass
    public void initiateObjects() {
        calculator = new Calculator();
    }

    @Test(priority = 1, dataProviderClass = CalculatorDataProvider.class, dataProvider = "addCalculatorDataProvider",
        description = "Test where we adding some amount of numbers and expect this data")
    public void testAddition(double expectedResult, double... numbers) {
        double result = calculator.add(numbers);

        Assert.assertEquals(result, expectedResult);
    }

    @AfterClass
    public void closeObjects() {
        calculator = null;
    }
}
