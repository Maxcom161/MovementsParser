public class RAM {

    private final String type;
    private final int volume;
    private final double weight;

    private static double weightRAM = 0; //todo вводим СТАТИЧЕСКУЮ переменную, которая будет считать вес оперативной памяти

    public RAM(String type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
        RAM.weightRAM = RAM.weightRAM + weight;
    }

    public static double getWeightRAM() {
        return weightRAM;
    }


    public String getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Тип памяти: " + type +
                " Объем памяти: " + volume + " Гб" +
                " Вес: " + weight + " гр.";
    }


}
