public class Main {

    public static void main(String[] args) {

        Dimensions box = new Dimensions(50, 20, 40);


        ParametersCargo cargo = new ParametersCargo(box, 30,
                "Russia", true,
                "98719237hyf", true);


        ParametersCargo cargo2 = cargo.setDeliveryAddress("Argentina");

        System.out.println(cargo);
        System.out.println();
        System.out.println(cargo2);

    }
}