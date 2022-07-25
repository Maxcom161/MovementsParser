public class TopManager implements Employee {

    private double salary;
    private Company company; // делается для того, чтобы получить доступ к income;

    public TopManager(Company company) {
        this.company = company;
        if (company.getIncome() > REQUIRED_BONUS_AMOUNT) {
            salary = FIX_SALARY_TOP_MANAGER * 1.5;
        } else {
            salary = FIX_SALARY_TOP_MANAGER;
        }
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

}
