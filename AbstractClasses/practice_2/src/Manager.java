public class Manager implements Employee {

    private int earnedMoney;
    protected double salary;

    public Manager() {
        salary = getMonthSalary();
    }


    public String toString() {
        return Math.round(salary) + "";
    }

    @Override
    public double getMonthSalary() {
        earnedMoney = (int) (Math.random() * ((MAX_EARNED_MONEY - MIN_EARNED_MONEY) + 1)) + MIN_EARNED_MONEY;
        salary = FIX_MANAGER + earnedMoney * 0.05;
        return salary;
    }
}
