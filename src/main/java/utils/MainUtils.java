package utils;

import java.util.Scanner;

public final class MainUtils {

    public static int readIntFromConsole() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static String isAdult(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Не можливий вік. Введіть вірне значення");
        }
        return age >= 18 ? "Ви доросла особа" : "Ви не є дорослою особою";
    }
}
