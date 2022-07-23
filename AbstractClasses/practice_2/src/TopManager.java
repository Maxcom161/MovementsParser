public class TopManager implements Employee {

    private double salary;

    public TopManager() {
        if (Company.getIncome() > REQUIRED_BONUS_AMOUNT) {
            this.salary = FIX_SALARY_TOP_MANAGER + (FIX_SALARY_TOP_MANAGER * 1.5);
        } else {
            this.salary = FIX_SALARY_TOP_MANAGER;
        }
    }


    public String toString() {
        return Math.round(salary) + "";
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

}
