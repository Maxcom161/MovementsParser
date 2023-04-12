import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WebParser {

    private final String htmlPath;
    private LinkedHashMap<String, MetroLine> listLines;
    private LinkedHashMap<String, MetroStation> listStations;



    public WebParser(String htmlPath) throws IOException {
        this.htmlPath = htmlPath;
        listLines = new LinkedHashMap<>();
        listStations = new LinkedHashMap<>();
        parseLinesAndStations();

    }

    public Document getHtmlCode() throws IOException {
        return Jsoup.connect(htmlPath).get();
    }

    public void parseLinesAndStations() throws IOException {
        Document document = getHtmlCode();

        for (Element infoLine : document.select(".js-depend")) {
            List<MetroStation> listStationOnTheLine = new ArrayList<>();
            String numberLine = infoLine.attr("data-depend-set").substring(6);
            String nameLine = document.getElementsByAttributeValue("data-line", numberLine).get(0).text(); // здесь мы ищем !!!!элементЫ!!!! по // значению "numberLine" в его аттрибутиве "data-line". После этого мы всегда берем ПЕРВЫЙ ЭЛЕМЕНТ и берем из него название станции.
            MetroLine metroLine = new MetroLine(numberLine, nameLine);
            for (Element station : infoLine.select(".single-station")) { // КЛЮЧЕВАЯ СТРОКА КОДА. Ищем станции именно по 1, 2, 3, ..., 17 элементу(линии);
                String fullName = station.text();
                int index = fullName.indexOf(" ");
                String result = fullName.substring(index + 1);
                MetroStation metroStation = new MetroStation(result, metroLine);
                listStationOnTheLine.add(metroStation);
                listStations.put(metroStation.getName(), metroStation);
            }
            metroLine.addListStation(listStationOnTheLine);
            listLines.put(numberLine, metroLine);
        }
    }

    public LinkedHashMap<String, MetroLine> getListLines() {
        return listLines;
    }

    public LinkedHashMap<String, MetroStation> getListStations() {
        return listStations;
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
