import utils.Utils;


public class Main {
    public static void main(String[] args) {

        System.out.println(Utils.averageValue(Utils.getArrayIntegersFromConsole()));

        System.out.println(Utils.minValueInArray(Utils.getArrayIntegersFromConsole()));

        System.out.println(Utils.maxValueInArray(Utils.getArrayIntegersFromConsole()));

        System.out.println(Utils.reverseElementsInArray(Utils.getArrayIntegersFromConsole()));
    }
}
