package utils;

import java.util.Scanner;

public final class Utils {

    private Utils(){}

    public static String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть слово");

        return scanner.nextLine();
    }

    public static int getNumberFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число");

        return scanner.nextInt();
    }

    public static String repeatEnd(String word, int number) {
        if (word.length() < number) {
            throw new IllegalArgumentException("Число не може бути більше довжини слова.");
        }

        String partForRepeat = word.substring((word.length() - number));

        return partForRepeat.repeat(number);
    }

    public static StringBuilder mixString(String firstWord, String secondWord) {
        if (firstWord == null || secondWord == null) {
            throw new IllegalArgumentException("Потрібно ввести 2 слова");
        }

        StringBuilder result = new StringBuilder();

        int minLength = Math.min(firstWord.length(), secondWord.length());
        for (int i = 0; i < minLength; i++) {
            result.append(firstWord.charAt(i));
            result.append(secondWord.charAt(i));
        }

        if (firstWord.length() > secondWord.length()) {
            result.append(firstWord.substring(minLength));
        } else {
            result.append(secondWord.substring(minLength));
        }

        return result;
    }
}
