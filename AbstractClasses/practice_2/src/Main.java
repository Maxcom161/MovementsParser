public class Main {

    public static void main(String[] args) {

        Company company = new Company("10 planeta");

        System.out.println(company + "\n");

        company.hire(new Operator());
        company.hire(new Operator());

        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());
        company.hire(new Manager());

        company.hire(new TopManager());
        company.hire(new TopManager());


        System.out.println(company); //проверка размера списка (все сотрудники добавляются)
        System.out.println(company.getTopSalaryStaff(10));
        System.out.println(company.getLowestSalaryStaff(10));

        System.out.println(company.sort()); //проверка отделього метода по сортировке
    }
}



