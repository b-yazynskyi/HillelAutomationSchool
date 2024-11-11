package tests;

import data_providers.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Calculator;

import java.util.Arrays;

public class CalculatorTest extends BaseTest {
    private Calculator calculator;

    @BeforeClass
    public void initiateObjects() {
        calculator = new Calculator();
    }

    @Test(priority = 1, dataProviderClass = CalculatorDataProvider.class, dataProvider = "addCalculatorDataProvider",
        description = "Test where we adding some amount of numbers")
    public void testAddition(double expectedResult, double... numbers) {
        double result = calculator.add(numbers);

        System.out.println("The result of adding numbers: " + Arrays.toString(numbers) + " is " + result);
        Assert.assertEquals(result, expectedResult);
    }

    @Test(priority = 2, dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "subtractCalculatorDataProvider",
            description = "Test where we subtracting some amount of numbers"
    )
    public void testSubtraction(double expectedResult, double... numbers) {
        double result = calculator.subtract(numbers);

        System.out.println("The result of subtraction numbers: " + Arrays.toString(numbers) + " is " + result);
        Assert.assertEquals(result, expectedResult);
    }

    @Test(priority = 1, dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "multiplyCalculatorDataProvider",
            description = "Test where we multiplying some amount of numbers"
    )
    public void testMultiplication(double expectedResult, double... numbers) {
        double result = calculator.multiply(numbers);

        System.out.println("The result of multiplying numbers: " + Arrays.toString(numbers) + " is " + result);
        Assert.assertEquals(result, expectedResult);
    }

    @Test(priority = 1, dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "divideCalculatorDataProvider",
            description = "Test where we diving some amount of numbers"
    )
    public void testDivision(double expectedResult, double... numbers) {
        double result = calculator.divide(numbers);

        System.out.println("The result of division numbers: " + Arrays.toString(numbers) + " is " + result);
        Assert.assertEquals(result, expectedResult);
    }

    @Test(priority = 1, expectedExceptions = ArithmeticException.class,
            dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "zeroDivisionCalculatorDataProvider",
            description = "Negative test to check exception when we try divide for 0"
    )
    public void testZeroDivision(double... numbers) {
        calculator.divide(numbers);

        System.out.println("The result of division numbers: " + Arrays.toString(numbers) + " is ArithmeticException");
    }

    @AfterClass
    public void closeObjects() {
        calculator = null;
    }
}
