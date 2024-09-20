package utils;

import java.util.Scanner;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public final class Utils {

    public static int readIntFromConsole() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static String isAdult(int age) throws IllegalArgumentException {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Не можливий вік.");
        }
        return age >= 18 ? "Ви доросла особа" : "Ви не є дорослою особою";
    }

    public static boolean isPerfectSquare(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число не може бути меньше 0");
        }
        double root =  round(sqrt(number));
        return root * root == number;
    }

    public static long sumNumbersFromOneToNumber(int number) {
        int i = 1;
        long result = 0;
        while (i++ != number + 1) {
            result += i;
        }
        return result;
    }
}
