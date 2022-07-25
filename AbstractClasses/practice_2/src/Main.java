import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Company company = new Company("10 Планета");

        System.out.println(company);
        System.out.println("Нанимаем сотрудников");
        System.out.println("---------------------");
        List<Employee> staff = new ArrayList<>(); // найм содтрудников
        for (int i = 0; i < 180; i++) {
            staff.add(new Operator());
        }
        for (int i = 0; i < 80; i++) {
            staff.add(new Manager());
            if (i % 8 == 0) {
                staff.add(new TopManager(company));
            }
        }
        company.hireAll(staff); // нанимаем список сотрудников staff
        printListSalaryStaff(company);
        System.out.println(company);

        for (int i = 0; i < 135; i++) { // увольняем 50%
            company.fire(company.getEmployees().get(i));
        }

        System.out.println("Удалено 50% сотрудников каждого класса");

        printListSalaryStaff(company);
        System.out.println(company);

    }
    //todo создаем метод через Refactor -> Extract -> Method (предварительно выделив логику метода)
    private static void printListSalaryStaff(Company company) {
        System.out.println("Самый высокий оклад:");
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(15);
        for (Employee employee : topSalaryStaff) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }
        System.out.println("-------------------------");
        System.out.println("Самый низкий оклад:");
        List<Employee> lowSalaryStaff = company.getLowestSalaryStaff(30);
        for (Employee employee : lowSalaryStaff) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }
        System.out.println("-------------------------");
    }
}



