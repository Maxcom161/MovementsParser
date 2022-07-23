public class Manager implements Employee {

    private int earnedMoney;
    private double salary;
    public Manager() {
        earnedMoney = (int) (Math.random() * ((MAX_EARNED_MONEY - MIN_EARNED_MONEY) + 1)) + MIN_EARNED_MONEY;
        this.salary = FIX_MANAGER + earnedMoney * 0.05;
    }

    public String toString() {
        return Math.round(salary) + "";
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

}
