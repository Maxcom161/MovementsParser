import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParce {

    FindFiles files = new FindFiles();
    WebParser webParser = new WebParser("https://skillbox-java.github.io/");
    Map<String, MetroStation> list;

    public JsonParce() throws IOException {
        list = new HashMap<>(webParser.getListStations());
        parseDepthStation();

    }

    public void parseDepthStation() {
        List<File> listJsonFile = files.startSearch("C:/Users/Admin/Desktop/stations-data");
        for(File file : listJsonFile) {
            if(!file.getAbsolutePath().endsWith(".json")) {
                continue;
            }
            try {
                JSONParser parser = new JSONParser();
                JSONArray jsonArrayStations = (JSONArray) parser.parse(getJsonFiles(file.getAbsolutePath()));
                for (Object jsObject : jsonArrayStations) {
                    JSONObject station = (JSONObject) jsObject;
                    String nameStation = (String) station.get("station_name");
                    String depthStation = (String) station.get("depth");
                    if(depthStation.equals("?")) {
                        continue;
                    }
                    list.keySet().forEach(s -> {
                        if (s.equalsIgnoreCase(nameStation)) {
                            MetroStation metroStation = list.get(s);
                            double depth = Double.parseDouble(depthStation.replace(",", "."));
                            if(metroStation.getDepth() == null || depth < Double.parseDouble(metroStation.getDepth())){
                                metroStation.setDepth(depthStation.replace(",", "."));
                            }
                        }
                    });
                }
//                jsonArrayStations.forEach(jsObject -> {
//                    JSONObject jsonObjectStation = (JSONObject) jsObject;
//                    String nameStation = (String) jsonObjectStation.get("station_name");
//                    String depthStation = (String) jsonObjectStation.get("depth");
//                    list.keySet().forEach(s -> {
//                        if (s.equalsIgnoreCase(nameStation)) {
//                            MetroStation metroStation = list.get(s);
//                            double depth = Double.parseDouble(depthStation.replace(",", "."));
//                            if(metroStation.getDepth() == 10000.0 || depth < metroStation.getDepth()){
//                                metroStation.setDepth(depth);
//                            }
//                        }
//                    });
//                });
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public String getJsonFiles(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> stringBuilder.append(line));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public Map<String, MetroStation> getList() {
        return list;
    }

}
