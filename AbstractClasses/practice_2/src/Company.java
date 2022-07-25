import java.util.*;

public class Company{

    private List<Employee> employees;
    private String name;

    public Company(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(Collection<Employee> employes) {
        for (Employee employee : employes) {
            hire(employee);
        }
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public int getIncome() {
        int income = 0; // делается для того, чтобы при вызови getIncome не суммировался постоянно income;
        for (Employee employee : employees){
            if(employee instanceof Manager){
                income += ((Manager) employee).getSales();
                //todo доход складывается от заработанных менеджерами денег. (getSales)
            }
        }
        return income;
    }

    //todo так как везде есть компаратор, в этом методе для
    //todo сортировки можно использовать встроенный компаратор.
    public List<Employee> getTopSalaryStaff(int count) {
        return getList(count, Comparator.reverseOrder());
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return getList(count, Comparator.naturalOrder());
    }

    private List<Employee> getList (int count, Comparator cmp) {
        if (count < 0) {
            System.out.println("Перадано неверное значение!");
            return Collections.emptyList(); //new ArrayList<>();
        }
        if (count > employees.size()) {
            count = employees.size();
        }
        employees.sort(cmp);
        return new ArrayList<>(employees.subList(0, count));
    }

//    public List<Employee> getTopSalaryStaff(int count) { // можно упростить еще больше.
//        Collections.sort(employees);
//        Collections.reverse(employees);
//        return employees.subList(0, count);
//    }
//
//    public List<Employee> getLowestSalaryStaff(int count) { // можно упростить еще больше.
//      Collections.sort(employees);
//      return employees.subList(0, count);
//    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees); // Защищаем список путем создания новой ссылки на объекты.
        //todo в списке хранится ССЫЛКА на объект. В нашем случае объекты - одинаковый, но ссылки разные,
        //todo засчет создания нового списка в геттере.
    }


    @Override
    public String toString() {
        return "Наименовании организации: " + "\"" + name + "\"" + "\n" +
                "Доход компании: " + getIncome() + " руб." + "\n" +
                "Количество сотрудников: " + employees.size();
    }
}