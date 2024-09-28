import utils.Utils;

public class Main {
    public static void main(String[] args) {

        // Task 7.1
        try {
            System.out.println(Utils.repeatEnd(Utils.getStringFromUser(), Utils.getNumberFromUser()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 7.2
        try {
            System.out.println(Utils.mixString(Utils.getStringFromUser(), Utils.getStringFromUser()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Task 7.3
        System.out.println(Utils.xyzMiddle(Utils.getStringFromUser()));

        // Task 7.4
        System.out.println(Utils.zipZap(Utils.getStringFromUser()));

        // Task 7.5
        System.out.println(Utils.xyzThere(Utils.getStringFromUser()));
    }
}
