import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Company company = new Company("10 Планета");

        int operator = 180;
        int manager = 80;
        int topManager = 10;

        System.out.println(company + "\n");

        company.addListEmployees(operator, manager, topManager); // add list Employees

        company.printListSalary(company.getTopSalaryStaff(15)); // print top salary
        company.printListSalary(company.getLowestSalaryStaff(30)); // print lowest salary


        for (int o = 0; o < operator / 2; o++) { //delete 50% Operators
            company.fire(company.getEmployees().get(o));
        }
        for (int m = operator / 2; m < (operator + manager) / 2; m++) { //delete 50% Managers
            company.fire(company.getEmployees().get(m));
        }
        for (int t = (operator + manager) / 2; t < (operator + manager + topManager) / 2; t++) { //delete 50% TopManagers
            company.fire(company.getEmployees().get(t));
        }

        System.out.println("Удалено 50% сотрудников каждого класса");

        company.printListSalary(company.getTopSalaryStaff(15)); // print top salary
        company.printListSalary(company.getLowestSalaryStaff(30)); // print lowest salary


    }
}



