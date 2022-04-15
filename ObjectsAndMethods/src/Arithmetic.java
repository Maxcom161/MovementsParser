public class Arithmetic {

    private int x = 0;
    private int y = 0;
    private int resultOffAction = 0;

    public Arithmetic(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Число: " + x + " Число: " + y);
        System.out.println();
    }

    public void multiplicationNumbers() {
        resultOffAction = x * y;
        System.out.println("Произведение чисел: " + resultOffAction);
    }

    public void sumNumbers() {
        resultOffAction = x + y;
        System.out.println("Сумма чисел: " + resultOffAction);
    }

    public void maxOrMinNumber() {
        if (x > y) {
            System.out.println("Максимальное число: " + x);
            System.out.println("Минимальное число: " + y);
        } else {
            System.out.println("Максимальное число: " + y);
            System.out.println("Минимальное число: " + x);
        }
    }

    public static void main(String[] args) {
        Arithmetic numbers1 = new Arithmetic(7, 8);
        numbers1.sumNumbers();
        numbers1.multiplicationNumbers();
        numbers1.maxOrMinNumber();

    }
}