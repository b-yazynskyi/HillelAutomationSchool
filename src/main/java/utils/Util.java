package utils;

import java.util.HashMap;
import java.util.Scanner;

public final class Util {

    private Util(){}

    public static String[] getStringsArrayFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string, all words will be split by space");
        return scanner.nextLine().split(" ");
    }

    public static HashMap<String, Integer> getLengthOfStrings(String[] strings) {
        HashMap<String, Integer> resultMap = new HashMap<>();

        for (String s : strings) {
            resultMap.put(s, s.length());
        }

        return resultMap;
    }
}
