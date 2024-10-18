package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Util {

    private Util(){}

    public static String[] getStringsArrayFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string, all words will be split by space");
        return scanner.nextLine().split(" ");
    }

    public static Map<String, Integer> getLengthOfStrings(String[] strings) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (String s : strings) {
            resultMap.put(s, s.length());
        }

        return resultMap;
    }
}
