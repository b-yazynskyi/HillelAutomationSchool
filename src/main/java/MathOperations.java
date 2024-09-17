public class MathOperations {

    public int squareNumber(int number) {
        return number * number;
    };

    public double calculateVolumeOfCylinder(double radius, double high) {
        return Math.PI * Math.pow(radius, 2) * high;
    }

    public int elevationOfNumberToPower(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

}
