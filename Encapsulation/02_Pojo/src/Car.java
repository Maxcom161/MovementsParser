public class Car {

    private String model;
    private String madeInCountry;
    private double volumeEngineCCM;
    private String color;


    public Car(String model, double volumeEngineCCM) {
        this.model = model;
        this.volumeEngineCCM = volumeEngineCCM;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMadeInCountry() {
        return madeInCountry;
    }

    public void setMadeInCountry(String madeInCountry) {
        this.madeInCountry = madeInCountry;
    }

    public double getVolumeEngineCCM() {
        return volumeEngineCCM;
    }

    public void setVolumeEngineCCM(double volumeEngineCCM) {
        this.volumeEngineCCM = volumeEngineCCM;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}



