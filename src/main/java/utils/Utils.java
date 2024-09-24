package utils;


public final class Utils {

    private Utils(){};

    public static int averageValue(int[] numbers) {

        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result / numbers.length;
    }

}
