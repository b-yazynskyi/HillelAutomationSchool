package utils;


import java.util.Arrays;
import java.util.Scanner;

public final class Utils {

    private Utils(){}

    public static int[] getArrayIntegersFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть розмір масиву");

        int size = scanner.nextInt();

        System.out.println("Введіть " + size + " цілих чисел");

        int[] arrayNumbers = new int[size];

        for (int i = 0; i < arrayNumbers.length; i++) {
            arrayNumbers[i] += scanner.nextInt();
        }

        return arrayNumbers;
    }

    public static double averageValue(int[] numbers) {

        return Arrays.stream(numbers).average().orElse(0);
    }

    public static int minValueInArray(int[] numbers) {
        return Arrays.stream(numbers).min().orElse(0);
    }

    public static int maxValueInArray(int[] numbers) {
        return Arrays.stream(numbers).max().orElse(0);
    }

}
