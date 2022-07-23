import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Company implements Comparator<Employee> {

    private ArrayList<Employee> employees;
    private static int income;
    private String name;
    private int amountStaff;

    public Company(String name) {
        this.name = name;
        employees = new ArrayList<Employee>();
        income = (int) (Math.random() * ((13_000_000 - 8_000_000) + 1)) + 8_000_000;
    }

    Comparator<Employee> comparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (int) (o1.getMonthSalary() - (int) o2.getMonthSalary());
        }
    };

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(Collection<Employee> employes) {
        employees.addAll(employes);
    }

    public void fire(Employee employee) {
        employees.remove(employee);

    }

    public static int getIncome() {
        return income;
    }

    public ArrayList <Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> listTopSalary = new ArrayList<>();
        System.out.println("Список из " + count +  " самых высоких окладов:");
        Collections.sort(employees, comparator.reversed());
        for (int i = 0; i < count; i++) {
            listTopSalary.add(employees.get(i));
        }
        return listTopSalary;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> listLowSalary = new ArrayList<>();
        System.out.println("Список из " + count + " самых низких окладов:");
        Collections.sort(employees, comparator);
        for (int i = 0; i < count; i++) {
            listLowSalary.add(employees.get(i));
        }

        return listLowSalary;
    }

    public void addListEmployees(int operator, int manager, int topManager) {
        for (int o = 0; o < operator; o++) {
            employees.add(new Operator());
        }
        for (int m = 0; m < manager; m++) {
            employees.add(new Manager());
        }
        for (int t = 0; t < topManager; t++) {
            employees.add(new TopManager());
        }
    }

    public void printListSalary(ArrayList<Employee> employees) {
        for (Employee salary : employees) {
            System.out.println(salary + " руб.");
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Employee> getSortList(ArrayList<Employee> employees) {
        ArrayList<Employee> sortList = new ArrayList<>(employees);
        Collections.sort(sortList, comparator);
        return sortList;
    }



    @Override
    public String toString() {
        return "Наименовании организации: " + "\"" + name + "\"" + "\n" +
                "Доход компании: " + income + " руб." + "\n" +
                "Количество сотрудников: " + employees.size();
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getMonthSalary() - o2.getMonthSalary());
    }
}