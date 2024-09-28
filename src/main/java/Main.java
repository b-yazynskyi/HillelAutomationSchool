import utils.Utils;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println(Utils.repeatEnd(Utils.getStringFromUser(), Utils.getNumberFromUser()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Utils.mixString(Utils.getStringFromUser(), Utils.getStringFromUser()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Utils.xyzMiddle(Utils.getStringFromUser()));
    }
}
