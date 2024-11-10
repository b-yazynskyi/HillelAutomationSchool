package utils;

public class Calculator {

    public Calculator() {}

    public double add(double... numbers) {
        double result = 0;
        for (double number : numbers) {
            result += number;
        }

        return result;
    }

    public double subtract(double... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }

        return result;
    }

    public double multiply(double... numbers) {
        double result = 1;
        for (double number : numbers) {
            result *= number;
        }

        return result;
    }

    public double divide(double... numbers) throws ArithmeticException {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least 1 number must be");
        }

        double result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("The divisor 0 is impossible");
            }

            result /= numbers[i];
        }

        return result;
    }

}
