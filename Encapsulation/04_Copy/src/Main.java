public class Main {

    public static void main(String[] args) {

        Dimensions box = new Dimensions(50, 20, 40, 0);
        box.getVolume();

        ParametersCargo cargo = new ParametersCargo(box, 30,
                "Russia", true,
                "98719237hyf", true);
        cargo.setDeliveryAddress("Argentina");


        System.out.println(cargo);





    }
}