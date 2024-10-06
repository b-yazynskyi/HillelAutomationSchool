package utils;

import java.util.*;
import java.util.stream.Collectors;

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

    public static int centeredAverage(int[] array) throws IllegalArgumentException {
        if (array.length < 3) {
            throw new IllegalArgumentException("Массив має бути 3 або більше елементи");
        }

        List<Integer> arrayOfNumbers = Arrays.stream(array).boxed().collect(Collectors.toList());

        Optional<Integer> minElement = arrayOfNumbers.stream().min(Comparator.naturalOrder());

        minElement.ifPresent(arrayOfNumbers::remove);

        Optional<Integer> maxElement = arrayOfNumbers.stream().max(Comparator.naturalOrder());

        maxElement.ifPresent(arrayOfNumbers::remove);

        int sum = arrayOfNumbers.stream().mapToInt(Integer::intValue).sum();
        return sum / arrayOfNumbers.size();
    }

    public static int countEvenInts(int[] array) {
        int countEven = 0;

        for (int num : array) {
            if (num % 2 == 0) {
                countEven++;
            }
        }

        return countEven;
    }
}
