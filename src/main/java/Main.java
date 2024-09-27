import utils.Utils;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println(Utils.repeatEnd(Utils.getStringFromUser(), Utils.getNumberFromUser()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
