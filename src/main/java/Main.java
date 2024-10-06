import utils.Utils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Task 8.1
        System.out.println(Utils.catDog(Utils.getStringFromUser()));

        // Task 8.1(part 2)
        System.out.println(Utils.countEvenInts(Utils.getArrayOfNumbersFromUser()));

        // Task 8.2
        try {
            System.out.println(Utils.centeredAverage(Utils.getArrayOfNumbersFromUser()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 8.3
        System.out.println(Utils.sumIgnoreSections(Utils.getArrayOfNumbersFromUser()));

        // Task 8.4
        System.out.println(Utils.sumWithoutUnlucky13(Utils.getArrayOfNumbersFromUser()));

    }
}
