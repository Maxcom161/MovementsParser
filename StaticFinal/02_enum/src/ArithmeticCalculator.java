public class ArithmeticCalculator {
    public static int x = 0;
    public static int y = 0;
    public static double result = 0;


    public ArithmeticCalculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double calculate(Operation actions) { //todo в случае ENUM значений придумываем в скобках ЛЮБУЮ переменную, вместо которой будем ставить ENUM значения
        if (actions == Operation.ADD) {
            return x + y;
        } else if (actions == Operation.SUBTRACT) {
            return x - y;
        } else if (actions == Operation.MULTIPLY) {
            return x * y;
        }
        return ArithmeticCalculator.result;
    }
}