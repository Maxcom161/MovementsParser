public class TopManager implements Employee {

    private double salary;


    public TopManager() {
        salary = getMonthSalary();
    }


    public String toString() {
        return Math.round(salary) + "";
    }

    @Override
    public double getMonthSalary() {
        if (Company.getIncome() > REQUIRED_BONUS_AMOUNT) {
            salary = FIX_SALARY_TOP_MANAGER + (FIX_SALARY_TOP_MANAGER * 1.5);
        } else {
            salary = FIX_SALARY_TOP_MANAGER;
        }
        return salary;
    }
}
