import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введіть ціле число: ");
            int userNumber = scanner.nextInt();
            int squareOfNumber = MathOperations.squareNumber(userNumber);
            System.out.printf("Квадрат числа %d дорівнює %d%n", userNumber, squareOfNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Некорретне значення");
            scanner.close();
        }

        try {
            System.out.println("Введіть радіус циліндра: ");
            double userRadius = scanner.nextDouble();
            System.out.println("Введіть висоту циліндра: ");
            double userHigh = scanner.nextDouble();
            double volumeOfCylinder = MathOperations.calculateVolumeOfCylinder(userRadius, userHigh);

            System.out.printf("Об'єм циліндра з радіусом %s і висотою %s дорівнює %s%n", userRadius, userHigh, volumeOfCylinder);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Некорретне значення");
            scanner.close();
        }

        try {
            System.out.println("Введіть a ");
            int userA = scanner.nextInt();
            System.out.println("Введіть b ");
            int userB = scanner.nextInt();
            int elevationOfNumber = MathOperations.elevationOfNumberToPower(userA, userB);
            System.out.printf("Результат %s ^ %s дорівнює %s.", userA, userB, elevationOfNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Некорректне значення");
            scanner.close();
        }


    }
}
