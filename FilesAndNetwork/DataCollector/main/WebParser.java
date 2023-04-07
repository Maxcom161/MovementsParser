import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WebParser {

    private final String htmlPath;
    private final LinkedHashMap<String, MetroLine> listLines;
    private final Set<MetroLine> list = new HashSet<>();

    public Set<MetroLine> getList() {
        return list;
    }


    public WebParser(String htmlPath) {
        this.htmlPath = htmlPath;
        listLines = new LinkedHashMap<>();
    }

    public Document getHtmlCode() throws IOException {
        return Jsoup.connect(htmlPath).get();
    }

    public void parseLinesAndStations(String path) throws IOException {
        Document document = getHtmlCode();
        JSONObject rootObj = new JSONObject();
        LinkedHashMap <String, JSONArray> buffer = new LinkedHashMap<>();
        JSONArray allLine = new JSONArray();
        
        for (Element infoLine : document.select(".js-depend")) {

            List<MetroStation> listStation = new ArrayList<>();
            JSONArray allStationOnTheLine = new JSONArray();

            String numberLine = infoLine.attr("data-depend-set").substring(6);
            String nameLine = document.getElementsByAttributeValue("data-line", numberLine).get(0).text();
            // здесь мы ищем !!!!элементЫ!!!! по
            // значению "numberLine" в его аттрибутиве "data-line". После этого мы всегда берем ПЕРВЫЙ ЭЛЕМЕНТ и берем из него название станции.
            MetroLine metroLine = new MetroLine(numberLine, nameLine);
            JSONObject object = new JSONObject();
            object.put("number", numberLine);
            object.put("name", nameLine);
            allLine.add(object);

            for (Element station : infoLine.select(".single-station")) {
                // КЛЮЧЕВАЯ СТРОКА КОДА. Ищем станции именно по 1, 2, 3, ..., 17 элементу(линии);
                MetroStation metroStation = new MetroStation(station.text(), metroLine);
                listStation.add(metroStation);
                allStationOnTheLine.add(metroStation.getName());
            }
            metroLine.addListStation(listStation);
            listLines.put(numberLine, metroLine);

            buffer.put(numberLine, allStationOnTheLine);

        }
        rootObj.put("stations", buffer);
        rootObj.put("lines", allLine);

        try(FileOutputStream output = new FileOutputStream(path))
        {

            output.write(rootObj.toString().getBytes(StandardCharsets.UTF_8));
        }

    }

    public LinkedHashMap<String, MetroLine> getListLines() {
        return listLines;
    }

    public MetroLine getMetroLine(String numberLine) {
        return listLines.get(numberLine);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, MetroLine> line : listLines.entrySet()) {
            stringBuilder.append(line.toString().replace("=", ""));
        }

        return stringBuilder + "";
    }
}
