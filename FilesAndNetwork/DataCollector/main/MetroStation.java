import java.util.TreeSet;

public class MetroStation {

    private String name;
    private MetroLine metroLine;


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

    @Override
    public String toString() {
        return name;
    }
}
