package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {

    private Utils() {}

    public static String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть слово:");

        return scanner.nextLine();
    }

    public static int[] getArrayOfNumbersFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть розмір масиву");

        int sizeArray = scanner.nextInt();

        System.out.println("Введіть " + sizeArray + " чисел");

        int[] arrayOfNumbers = new int[sizeArray];

        for (int i = 0; i < sizeArray; i++) {
            arrayOfNumbers[i] = scanner.nextInt();
        }

        return arrayOfNumbers;
    }

    public static boolean catDog(String word) {
        int catCount = word.split("cat", -1).length - 1;
        int dogCount = word.split("dog", -1).length - 1;

        return catCount == dogCount;
    }
}
