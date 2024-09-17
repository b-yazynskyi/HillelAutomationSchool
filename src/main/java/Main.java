import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathOperations mathOperator = new MathOperations();
        System.out.println("Введіть ціле число: ");

        int userNumber = scanner.nextInt();
        int squareOfNumber = mathOperator.squareNumber(userNumber);
        System.out.println("Квадрат числа " + userNumber + " дорівнює " + squareOfNumber);



    }
}
