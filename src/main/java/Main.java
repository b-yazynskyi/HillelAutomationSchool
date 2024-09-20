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


    }
}
