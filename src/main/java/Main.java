import utils.MainUtils;

public class Main {
    public static void main(String[] args) {

        // Task 5.1
        try {
            System.out.println("Введіть свій вік. А ми вирішимо за вас чи ви дорослий xD");

            int userAge = MainUtils.readIntFromConsole();

            System.out.println(MainUtils.isAdult(userAge));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
