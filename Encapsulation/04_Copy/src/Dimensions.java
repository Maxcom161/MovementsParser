public class Dimensions {

    private final double length;
    private final double width;
    private final double height;

    public Dimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Dimensions setLength(double length) {
        return new Dimensions(length, width, height);
    }

    public Dimensions setWidth(double width) {
        return new Dimensions(length, width, height);
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(length, width, height);
    }


    public double getLength() { return length; }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return height * width * length / 1000000; // m3
    }

    public String toString() {
        return "(размеры посылки: " +
                "длина - " + length + "см." +
                " ширина - " + width + "см." +
                " высота - " + height + "см." +")." +
                " Объем груза - " + getVolume() + " куб.м.";
    }
}