package utils;


import java.util.Arrays;

public final class Utils {

    private Utils(){};

    public static double averageValue(int[] numbers) {

        return Arrays.stream(numbers).average().isPresent() ? Arrays.stream(numbers).average().getAsDouble() : 0;
    }

}
