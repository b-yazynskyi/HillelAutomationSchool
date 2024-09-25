package utils;


import java.util.Arrays;
import java.util.Collections;
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

    public static int getNumberFromConsole() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число для пошуку у масиві");

        return scanner.nextInt();
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

    public static String reverseElementsInArray(int[] numbers) {

        Integer[] boxedArray = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Collections.reverse(Arrays.asList(boxedArray));

        return Arrays.toString(boxedArray);
    }

    public static String isNumberInArray(int[] numbers, int number) {
        return Arrays.stream(numbers).anyMatch(num -> num == number) ? "Число " + number + " є у масиві."
                : "Число " + number + " відсутнє у масиві";

    }

}
