package utils;

import java.util.*;

public final class Util {

    private Util(){}

    public static String[] getStringsArrayFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string, all words will be split by space");

        String input = scanner.nextLine();

        if (input.isEmpty()) {
            return new String[0];
        }

        return input.split("\\s+");
    }

    private static <T extends Collection<Integer>> T getIntegerCollectionFromUser(T collection) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integers separated by spaces");
        String input = scanner.nextLine();

        String[] numbers = input.split("\\s+");

        for (String number : numbers) {
            try {
                collection.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                System.out.println("'" + number + "' is not valid number, Skipping it.");
            }
        }

        return collection;
    }

    public static List<Integer> getIntegerListFromUser() {
        return getIntegerCollectionFromUser(new ArrayList<>());
    }

    public static LinkedHashSet<Integer> getLinkedHashSetFromUser() {
        return getIntegerCollectionFromUser(new LinkedHashSet<>());
    }

    public static TreeSet<Integer> getIntegerTreeSetFromUser() {
        return getIntegerCollectionFromUser(new TreeSet<>());
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

    public static Map<String, String> mergeStringsByFirstChar(String[] strings) {
        checkIfArrayEmpty(strings);

        Map<String, String> resultMap = new HashMap<>();

        StringBuilder combinedWord = new StringBuilder();

        for (String word : strings) {
            String s = String.valueOf(word.charAt(0));
            if (resultMap.containsKey(s)) {
                resultMap.put(s, resultMap.get(s) + word);
            } else {
                resultMap.put(s, word);
            }
        }
        return resultMap;
    }

    public static String buildResultString(String[] strings) {
        checkIfArrayEmpty(strings);

        Map<String, Integer> wordCount = new HashMap<>();
        String result = "";

        for (String word : strings) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

            if (wordCount.get(word) % 2 == 0) {
                    result = word;
            }
        }

        return result;
    }

    public static int findTheMostRepeatedElement(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (Integer element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        int mostFrequentElement = list.getFirst();
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentElement = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostFrequentElement;
    }

    public static boolean haveCommonElement(LinkedHashSet<Integer> setA, LinkedHashSet<Integer> setB) {
        for (Integer element : setA) {
            if (setB.contains(element)) {
                return true;
            }
        }
        return false;
    }

    public static TreeSet<Integer> merge2SetsTo1Set(TreeSet<Integer> setA, TreeSet<Integer> setB) {
        TreeSet<Integer> resultSet = new TreeSet<>(setA);
        resultSet.addAll(setB);

        return resultSet;
    }

}
