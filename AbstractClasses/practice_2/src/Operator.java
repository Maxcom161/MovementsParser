public class Operator implements Employee {

    private double salary;

    public Operator() {
        this.salary = FIX_SALARY_OPERATOR;;
    }

    public String toString() {
        return Math.round(salary) + "";
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
