public class MetroStation implements Comparable<MetroStation> {

    private final String name;
    private final MetroLine metroLine;
    private String depth;
    private String openingDate;
    private boolean hasConnection = false;


    public MetroStation(String name, MetroLine metroLine) {
        this.name = name;
        this.metroLine = metroLine;
    }

    public String getName(){
        return name;
    }

    public MetroLine getMetroLine() {
        return metroLine;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getDepth() {
        return depth;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public boolean isHasConnection() {
        return hasConnection;
    }

    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }




    @Override
    public String toString() {

        return name + " " + depth + " " + openingDate + " " + hasConnection;
    }

    @Override
    public int compareTo(MetroStation metroStation) {
        return name.compareToIgnoreCase(metroStation.getName());
    }
    @Override
    public boolean equals(Object obj)
    {
        return compareTo((MetroStation) obj) == 0;
    }





}
