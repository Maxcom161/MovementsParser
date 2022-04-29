public class CPU {

    private final double frequency;
    private final int numberOfCores;
    private final double manufacturer;
    private final double weight;
    private static double weightCPU = 0; //todo вводим СТАТИЧЕСКУЮ переменную, которая будет считать вес процессора



    public CPU(double frequency, int numberOfCores, double manufacturer, double weight) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
        CPU.weightCPU = CPU.weightCPU + weight;
    }

    public static double getWeightCPU() { //todo делаем СТАТИЧЕСКИЙ метод, который будет возвращать СТАТИЧЕСКУЮ переменную класс (weightCPU)
        return weightCPU;//todo к которому будем обращаться ИЗВНЕ (из класса компьютер).
    }



    public double getFrequency() {
        return frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public double getManufacturer() {
        return manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Частота процессора: " + frequency + " Мгц" +
                " Количество ядер: " + numberOfCores +
                " Производительность: " + manufacturer +
                " Вес: " + weight + " гр.";
    }
}
