public class Main {
    public static void main(String[] args) {
        ArithmeticCalculator numbers1 = new ArithmeticCalculator(5, 20);

        System.out.println(numbers1.calculate(Operation.SUBTRACT));
        System.out.println(numbers1.calculate(Operation.MULTIPLY));
        System.out.println(numbers1.calculate(Operation.ADD));

    }
}
