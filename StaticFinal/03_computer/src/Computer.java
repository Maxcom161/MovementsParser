public class Computer {

    private final String vendor;
    private final String name;
    private CPU cpu;
    private RAM ram;
    private InformationStorage informationStorage;
    private Screen screen;
    private Keyboard keyboard;
    private static double totalWeight; //todo вводим СТАТИЧЕСКУЮ переменную, которая будет считать вес ВСЕХ КОМПЛЕКТУЮЩИХ (ВСЕХ КЛАССОВ)


    public Computer(String vendor, String name, CPU cpu, RAM ram, InformationStorage informationStorage, Screen screen, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.informationStorage = informationStorage;
        this.screen = screen;
        this.keyboard = keyboard;
    }

    public static double calculateTotalWeight() { //todo делаем СТАТИЧЕСКИЙ метод, который будет обращаться с СТАТИЧЕСКИМ гетеррам из других классов.
        totalWeight = CPU.getWeightCPU() + RAM.getWeightRAM() +
                InformationStorage.getWeightInformationStorage() +
                Screen.getWeightScreen() + Keyboard.getWeightKeyboard();

        return totalWeight;

    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public InformationStorage getInformationStorage() {
        return informationStorage;
    }

    public void setInformationStorage(InformationStorage informationStorage) {
        this.informationStorage = informationStorage;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public String toString() {
        return "Компьютер и его комплектующие: " + "\n" +
                "Производство: " + vendor + "\n" +
                "Модель: " + name + "\n" +
                "Процессор - " + cpu + "\n" +
                "Оперативная память - " + ram + "\n" +
                "Накопитель - " + informationStorage + "\n" +
                "Дисплей - " + screen + "\n" +
                "Клавиатура - " + keyboard + "\n" +
                "Общий вес в сборе: " + calculateTotalWeight() + " гр.";

    }

}
