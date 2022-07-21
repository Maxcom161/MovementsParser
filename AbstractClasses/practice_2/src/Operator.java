public class Operator implements Employee {

    private double salary;

    public Operator() {
        salary = getMonthSalary();
    }

    public String toString() {
        return Math.round(salary) + "";
    }


    @Override
    public double getMonthSalary() {
        salary = FIX_SALARY_OPERATOR;
        return salary;
    }
}
