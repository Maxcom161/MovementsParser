public class Screen {

    private final double diagonal;
    private final ScreenConnectionType type;
    private final double weight;

    private  static double weightScreen = 0;

    public Screen(double diagonal, ScreenConnectionType type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
        Screen.weightScreen = Screen.weightScreen + weight;
    }

    public static double getWeightScreen() {
        return weightScreen;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public ScreenConnectionType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Диагональ: " + diagonal + "''" +
                " Тип подключения: " + type +
                " Вес: " + weight + " гр.";
    }


}
