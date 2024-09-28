package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean xyzMiddle(String word) {
        int wordLength = word.length();

        for (int i = 0; i <= wordLength - 3; i++) {

            if (word.startsWith("xyz", i)) {
                int right = wordLength - (i + 3);

                if (Math.abs(i - right) <= 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static StringBuilder zipZap(String word) {
        String pattern = "z.p";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(word);

        StringBuilder modifiedWord = new StringBuilder();

        int lastMatchEnd = 0;

        while (matcher.find()) {
            modifiedWord.append(word, lastMatchEnd, matcher.start());

            String modifiedPattern = matcher.group().charAt(0) + "" + matcher.group().charAt(2);

            modifiedWord.append(modifiedPattern);

            lastMatchEnd = matcher.end();
        }

        modifiedWord.append(word.substring(lastMatchEnd));

        return modifiedWord;
    }

    public static boolean xyzThere(String word) {
        String patternXyzWithDot = "\\.xyz";
        String patternWithOutDot = "xyz";

        if (word.matches(".*" + patternXyzWithDot + ".*")) {
            return false;
        } else
            return word.matches(".*" + patternWithOutDot + ".*");
    }
}
