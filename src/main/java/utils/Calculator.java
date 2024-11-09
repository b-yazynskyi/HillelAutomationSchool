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


}
