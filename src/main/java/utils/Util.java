package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Util {

    private Util(){}

    public static String[] getStringsArrayFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string, all words will be split by space");

        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            return new String[0];
        }

        return input.split("//s+");
    }

    private static void checkIfArrayEmpty(String[] strings) throws IllegalArgumentException {
        if (strings.length == 0) {
            throw new IllegalArgumentException("Array must have at list 1 item");
        }
    }

    public static Map<String, Integer> getLengthOfStrings(String[] strings) throws IllegalArgumentException {
        checkIfArrayEmpty(strings);

        Map<String, Integer> resultMap = new HashMap<>();

        for (String s : strings) {
            resultMap.put(s, s.length());
        }

        return resultMap;
    }

    public static Map<String, String> createMap(String[] strings) throws IllegalArgumentException {
        checkIfArrayEmpty(strings);

        Map<String, String> resultMap = new HashMap<>();

        for (String s : strings) {
            resultMap.put(s.substring(0, 1), s.substring(s.length() - 1));
        }

        return resultMap;
    }

    public static Map<String, Integer> countWords(String[] strings) throws IllegalArgumentException {
        checkIfArrayEmpty(strings);

        Map<String, Integer> resultMap = new HashMap<>();

        for (String s : strings) {
            if (resultMap.containsKey(s)) {
                resultMap.put(s, resultMap.get(s) + 1);
            } else {
                resultMap.put(s, 1);
            }
        }

        return resultMap;
    }

}
