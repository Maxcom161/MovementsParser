public class Keyboard {

    private final String type;
    private final boolean backlight;
    private final double weight;

    private static double weightKeyboard = 0;


    public Keyboard(String type, boolean backlight, double weight) {
        this.type = type;
        this.backlight = backlight;
        this.weight = weight;
        Keyboard.weightKeyboard = Keyboard.weightKeyboard + weight;
    }

    public static double getWeightKeyboard() {
        return weightKeyboard;
    }

    public String getType() {
        return type;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Тип клавиатуры: " + type +
                " Наличие подсветки: " + backlight +
                " Вес: " + weight + " гр.";
    }

}
