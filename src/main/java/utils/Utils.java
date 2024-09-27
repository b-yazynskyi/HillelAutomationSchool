package utils;

public final class Utils {

    private Utils(){}

    public static String repeatEnd(String word, int number) {

        if (word.length() < number) {
            throw new IllegalArgumentException("Число не може бути більше довжини слова.");
        }

        String partForRepeat = word.substring((word.length() - number));

        return partForRepeat.repeat(number);
    }
}
