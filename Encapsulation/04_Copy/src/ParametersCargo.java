public class ParametersCargo {


    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean canBeTurnedOver; // Можно переворачивать.
    private final String numberRegistration;
    private final boolean fragileCargo; // Хрупкий груз

    public ParametersCargo(Dimensions dimensions, double weight,
                           String deliveryAddress, boolean canBeTurnedOver,
                           String numberRegistration, boolean fragileCargo) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.canBeTurnedOver = canBeTurnedOver;
        this.numberRegistration = numberRegistration;
        this.fragileCargo = fragileCargo;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public ParametersCargo setDimensions(Dimensions dimensions) {
        return new ParametersCargo(dimensions, weight, deliveryAddress,
                canBeTurnedOver, numberRegistration, fragileCargo);
     }


    public double getWeight() {
        return weight;
    }


    public ParametersCargo setWeight(double weight) {
        return new ParametersCargo(dimensions, weight, deliveryAddress,
                canBeTurnedOver, numberRegistration, fragileCargo);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public ParametersCargo setDeliveryAddress(String deliveryAddress) {
        return new ParametersCargo(dimensions, weight, deliveryAddress,
                canBeTurnedOver, numberRegistration, fragileCargo);
    }

    public boolean isCanBeTurnedOver() {
        return canBeTurnedOver;
    }

    public String getNumberRegistration() {
        return numberRegistration;
    }

    public boolean isFragileCargo() {
        return fragileCargo;
    }

    public String toString() {
        return "Габариты посылки: " + dimensions + "\n" +
                "Вес: " + weight + " кг." + "\n" +
                "Адрес доставки: " + deliveryAddress + "\n" +
                "Можно переворачивать:  " + canBeTurnedOver + "\n" +
                "Регистрационный номер: " + numberRegistration + "\n" +
                "Хрупкий груз: " + fragileCargo;

    }

}