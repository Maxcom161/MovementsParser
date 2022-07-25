public class Operator implements Employee {

    private double salary;

    public Operator() {
        this.salary = FIX_SALARY_OPERATOR;;
    }


    @Override
    public double getMonthSalary() {
        return salary;
    }
}
