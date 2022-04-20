public class Country {

    private String name;
    private int population;
    private double squareInKm2;
    private String capital;
    private boolean AccessToTheSea;


    public Country(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getSquareInKm2() {
        return squareInKm2;
    }

    public void setSquareInKm2(double squareInKm2) {
        this.squareInKm2 = squareInKm2;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public boolean isAccessToTheSea() {
        return AccessToTheSea;
    }

    public void setAccessToTheSea(boolean accessToTheSea) {
        AccessToTheSea = accessToTheSea;
    }



}





