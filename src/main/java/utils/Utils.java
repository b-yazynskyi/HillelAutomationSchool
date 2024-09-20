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
        if (number <= 0) {
            throw new IllegalArgumentException("Хибні вхідні параметри");
        }
        int i = 1;
        long result = 1;
        while (i++ != number) {
            result += i;
        }
        return result;
    }

    public static String getGrade(int number) {
        if (number < 1 || number > 5) {
            throw new IllegalArgumentException("Неправильна оцінка");
        }

        return switch (number) {
            case 1 -> "Погано";
            case 2 -> "Незадовільно";
            case 3 -> "Задовільно";
            case 4 -> "Добре";
            case 5 -> "Відмінно";
            default -> "";
        };
    }

    public static boolean isPrime(int number) {

        if ( number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
