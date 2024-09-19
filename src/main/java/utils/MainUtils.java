package utils;

import java.util.Scanner;

public final class MainUtils {

    public static int readIntFromConsole() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static String isAdult(int age) {
        return age >= 18 ? "Ви доросла особа" : "Ви не є дорослою особою";
    }
}
