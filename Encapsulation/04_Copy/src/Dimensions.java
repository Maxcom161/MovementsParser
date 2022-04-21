public class Dimensions {

    private final double length;
    private final double width;
    private final double height;
    private double volume = 0;

    public Dimensions(double length, double width, double height, double volume) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = volume;
    }


    public Dimensions setLength(double length) {
        return new Dimensions(length, width, height, 0);
    }

    public Dimensions setWidth(double width) {
        return new Dimensions(length, width, height, 0);
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(length, width, height, 0);
    }


    public double getLength() { return length; }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void getVolume() {
        volume = height * width * length / 1000000; // m3
        return;

    }

    public String toString() {
        return "(размеры посылки: " +
                "длина - " + length + "см." +
                " ширина - " + width + "см." +
                " высота - " + height + "см." +")." +
                " Объем груза - " + volume + " куб.м.";
    }


}