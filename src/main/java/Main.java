import utils.Utils;


public class Main {
    public static void main(String[] args) {

        System.out.println("Середнє значення массиву: " + Utils.averageValue(Utils.getArrayIntegersFromConsole()));

        System.out.println("Мінімальне значення масиву: " + Utils.minValueInArray(Utils.getArrayIntegersFromConsole()));

        System.out.println("Максимальне значення масиву: " + Utils.maxValueInArray(Utils.getArrayIntegersFromConsole()));

        System.out.println("Перевернутий массив: " + Utils.reverseElementsInArray(Utils.getArrayIntegersFromConsole()));
        System.out.println(Utils.isNumberInArray(Utils.getArrayIntegersFromConsole(), Utils.getNumberFromConsole()));
    }
}
