import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MetroLine {

    private String name;
    private String numberLine;

    private ArrayList<MetroStation> stationList;


    public MetroLine(String numberLine, String name) {
        this.numberLine = numberLine;
        this.name = name;
        stationList = new ArrayList<>();
    }

    public void addStation(MetroStation station) {
        stationList.add(station);
    }

    public void addListStation(List<MetroStation> nameStation) {
        stationList.addAll(nameStation);
    }

    public String getName() {
        return name;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public ArrayList<MetroStation> getStationList() {
        return stationList;
    }

    public StringBuilder getStringListStation() {
        StringBuilder strB = new StringBuilder();
        stationList.forEach(station -> strB.append("\t" + station + "\n"));
        return strB;
    }


        @Override
    public String toString() {
        return " - " + name + ":" + "\n" + getStringListStation();
    }

}
