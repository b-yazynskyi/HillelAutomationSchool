package utils;

public final class Calculator {

    private Calculator() {}

    public static int add(int... numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    public static double add(double... numbers) {
        double result = 0;
        for (double number : numbers) {
            result += number;
        }

        return result;
    }

    public static int subtract(int... numbers) {
        int result = 0;
        for (int number : numbers) {
            result -= number;
        }

        return result;
    }

    public static double subtract(double... numbers) {
        double result = 0;
        for (double number : numbers) {
            result -= number;
        }

        return result;
    }

    public static int multiply(int... numbers) {
        int result = 1;
        for (int number : numbers) {
            result *= number;
        }

        return result;
    }

    public static double multiply(double... numbers) {
        double result = 1;
        for (double number : numbers) {
            result *= number;
        }

        return result;
    }

    public static int divide(int... numbers) throws ArithmeticException {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least 1 number must be");
        }

        int result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("The divisor 0 is impossible");
            }
            result /= numbers[i];
        }

        return result;
    }

    public static double divide(double... numbers) throws ArithmeticException {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least 1 number must be");
        }

        double result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("The divisor 0 is impossible")
            }

        }

        return result;
    }

}
