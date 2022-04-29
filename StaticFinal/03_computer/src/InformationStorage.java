public class InformationStorage {


    private final TypeInformationStorage type;
    private final int volume;
    private final double weight;
    public static double weightInformationStorage = 0;


    public InformationStorage(TypeInformationStorage type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
        InformationStorage.weightInformationStorage = InformationStorage.weightInformationStorage + weight;
    }

    public static double getWeightInformationStorage() {
        return weightInformationStorage;
    }

    public TypeInformationStorage getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Тип накопителя: " + type +
                " Объем памяти: " + volume + "Гб" +
                " Вес: " + weight + " гр.";
    }



}
