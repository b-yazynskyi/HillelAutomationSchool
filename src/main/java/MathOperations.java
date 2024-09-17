public final class MathOperations {

    private MathOperations() {
    }

    public static int squareNumber(int number) {
        if (number > Math.sqrt(Integer.MAX_VALUE) || number < -Math.sqrt(Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Число занадто велике щоб возвести у квадрат " +
                    "і залишитись у ліміті макс. значення int");
        }

        return number * number;
    }

    public static double calculateVolumeOfCylinder(double radius, double high) {
        if (radius < 0) {
            throw new IllegalArgumentException("Радіус не може бути меньше 0");
        }

        if (high < 0) {
            throw new IllegalArgumentException("Висота не може бути меньше 0");
        }

        return Math.PI * Math.pow(radius, 2) * high;
    }

    public static int elevationOfNumberToPower(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Степінь не може бути негативною");
        }

        int result = 1;

        for (int i = 0; i < b; i++) {
            result *= a;
        }

        return result;
    }

}
