import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateJsonFiles {

    CsvParce csvParce = new CsvParce();
    WebParser webParser = new WebParser("https://skillbox-java.github.io/");

    List<MetroStation> jsonStation = new ArrayList<>(csvParce.getListStations());


    public CreateJsonFiles() throws IOException {

    }

    public List<MetroStation> getJsonStation() {
        return jsonStation;
    }

//    public LinkedHashMap<String, MetroLine> getJsonLineAndStation() {
//        return jsonLineAndStation;
//    }

    public void parceSPBFormat(){
        JSONObject root = new JSONObject();
        JSONObject stations = new JSONObject();
        for(MetroLine line : webParser.getLines()){
            JSONArray jsonArrayStations = new JSONArray();
            for(MetroStation station : line.getStationList()){
                jsonArrayStations.add(station.getName());
            }
            stations.put(line.getNumberLine(), jsonArrayStations);


        }
        JSONArray jsonArrayParameters = new JSONArray();
        for(MetroLine line : webParser.getLines()) {
            JSONObject parametersLine = new JSONObject();
            parametersLine.put("number", line.getNumberLine());
            parametersLine.put("name", line.getName());
            jsonArrayParameters.add(parametersLine);
        }
        root.put("stations", stations);
        root.put("line", jsonArrayParameters);

        try (FileOutputStream fileOutputStream = new FileOutputStream("data/jsonSPBFormat.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(fileOutputStream, root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void parceSkillboxFormat(){
        JSONArray jsonArray = new JSONArray();

        for(MetroStation station : jsonStation) {
            JSONObject objectStation = new JSONObject();

            objectStation.put("line", station.getMetroLine().getName());
            objectStation.put("date", station.getOpeningDate());
            objectStation.put("depth", station.getDepth());
            objectStation.put("station-name", station.getName());
            jsonArray.add(objectStation);
        }
        try (FileOutputStream file = new FileOutputStream("data/jsonSkillboxFormat.json")) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
