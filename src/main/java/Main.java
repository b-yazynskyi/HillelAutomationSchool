import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathOperations mathOperator = new MathOperations();
        System.out.println("Введіть ціле число: ");

        int userNumber = scanner.nextInt();
        int squareOfNumber = mathOperator.squareNumber(userNumber);
        System.out.printf("Квадрат числа %d дорівнює %d%n", userNumber, squareOfNumber);

        System.out.println("Введіть радіус циліндра: ");

        double userRadius = scanner.nextDouble();
        System.out.println("Введіть висоту циліндра: ");
        double userHigh = scanner.nextDouble();
        double volumeOfCylinder = mathOperator.calculateVolumeOfCylinder(userRadius, userHigh);

        System.out.printf("Об'єм циліндра з радіусом %s і висотою %s дорівнює %s%n", userRadius, userHigh, volumeOfCylinder);

        System.out.println("Введіть a ");
        int userA = scanner.nextInt();
        System.out.println("Введіть b ");
        int userB = scanner.nextInt();
        double elevationOfNumber = mathOperator.elevationOfNumberToPower(userA, userB);
        System.out.printf("Результат %s ^ %s дорівнює %sn", userA, userB, elevationOfNumber);

    }
}
