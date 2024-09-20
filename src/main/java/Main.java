import utils.Utils;

public class Main {
    public static void main(String[] args) {

        // Task 5.1
        try {
            System.out.println("Введіть свій вік. А ми вирішимо за вас чи ви дорослий xD");

            int userAge = Utils.readIntFromConsole();

            System.out.println(Utils.isAdult(userAge));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 5.2
        try {
            System.out.println("Введіть ціле число для перевірки чи це ідеальний квадрат");

            int userNumber = Utils.readIntFromConsole();

            System.out.println(Utils.isPerfectSquare(userNumber));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 5.3
        try {
            System.out.println("Введіть число від 1");

            int userNumber = Utils.readIntFromConsole();

            System.out.println(Utils.sumNumbersFromOneToNumber(userNumber));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 5.4
        try {
            System.out.println("Введіть оцінку від 1 до 5");

            int userMark = Utils.readIntFromConsole();

            System.out.println(Utils.getGrade(userMark));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 5.5
        try {
            System.out.println("Введіть число");

            int userNumber = Utils.readIntFromConsole();

            System.out.println(Utils.isPrime(userNumber));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
