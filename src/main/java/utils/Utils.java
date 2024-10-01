package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {

    private Utils() {}

    public static String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static boolean catDog(String word) {
        int catCount = word.split("cat", -1).length - 1;
        int dogCount = word.split("dog", -1).length - 1;

        return catCount == dogCount;
    }
}
