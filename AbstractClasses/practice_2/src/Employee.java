public interface Employee extends Comparable<Employee> {

    int FIX_MANAGER = 100000;
    int MIN_EARNED_MONEY = 115000;
    int MAX_EARNED_MONEY = 140000;
    int REQUIRED_BONUS_AMOUNT = 10_000_000;
    int FIX_SALARY_TOP_MANAGER = 150000;
    int FIX_SALARY_OPERATOR = 75000;

    double getMonthSalary();

    //todo В интерфейсе можно реализовывать дефолтные методы.
    //todo Это те методы, которые содержит интерфейс. В данном случае Comparable

    @Override
    default int compareTo(Employee o) {
        return (int) (getMonthSalary() - o.getMonthSalary());
    }
}
