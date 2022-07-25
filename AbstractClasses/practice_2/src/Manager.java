public class Manager implements Employee {

    private double salary;
    private int sales;

    public Manager() {
       sales = (int) (Math.random() * ((MAX_EARNED_MONEY - MIN_EARNED_MONEY) + 1)) + MIN_EARNED_MONEY;
       salary = (int) (FIX_MANAGER + sales * 0.05);
    }

    public int getSales() {
        return sales;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

}
