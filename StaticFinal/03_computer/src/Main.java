public class Main {
    public static void main(String[] args) {

        Computer computer = new Computer("Russia", "Крым-наш!", new CPU(4.4, 8, 8800, 50),
                new RAM("DDR3", 16, 80), new InformationStorage(TypeInformationStorage.SDD, 800, 350),
                new Screen(72, ScreenConnectionType.TN, 7600),
                new Keyboard("MECHANIC", true, 800));
        System.out.println(computer);



//        CPU cpu = new CPU(4.4, 8, 8700, 50);
//        System.out.println(cpu);
//        RAM ram = new RAM ("DDR3", 16, 80);
//        System.out.println(ram);
//        InformationStorage informationStorage = new InformationStorage(TypeInformationStorage.SDD, 500, 350);
//        System.out.println(informationStorage);
//        Screen screen = new Screen(52, ScreenConnectionType.IPS, 7000);
//        System.out.println(screen);
//        Keyboard keyboard = new Keyboard("Механическая", true, 800);
//        System.out.println(keyboard);

    }
}
