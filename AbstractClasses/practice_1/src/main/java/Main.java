public class Main {
    public static void main(String[] args) {

        PhysicalPersonClient physicalPersonClient = new PhysicalPersonClient();
        CompanyClient companyClient = new CompanyClient();
        IndividualEntrepreneurClient individualEntrepreneurClient = new IndividualEntrepreneurClient();

        physicalPersonClient.put(1000);
        physicalPersonClient.take(123);

        companyClient.put(2000);
        companyClient.take(1000);

        individualEntrepreneurClient.put(10000);
        individualEntrepreneurClient.take(900);

        System.out.println(physicalPersonClient.info());
        System.out.println(companyClient.info());
        System.out.println(individualEntrepreneurClient.info());

    }
}
