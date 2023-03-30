import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {

        String jsonFile = Files.readString(Paths.get("src/main/resources/map.json"));


        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonData = objectMapper.readTree(jsonFile);

        JsonNode stations = jsonData.get("stations"); //todo получаем узел (ноду) stations из всего файла
        JsonNode lines = jsonData.get("lines"); //todo аналогичо с линиями


        for(JsonNode line : lines) {
            ObjectNode lineNode = (ObjectNode) line;
            lineNode.remove("color"); //todo удаляем ключ color вместе с его значениями
            String lineNumber = line.get("number").asText(); //todo получаем номер линии по ключу number
            JsonNode listStations = stations.get(lineNumber); //todo получаем список станций по ключу lineNumber
            int size = listStations.size();
            lineNode.put("stationsCount", size); //todo добавляем ключ - значение.

            System.out.println(line);
        }
        ObjectMapper objectMapperNewVersion = new ObjectMapper();
        File output = new File("export.json");
        objectMapperNewVersion.writeValue(output, lines);

    }
}
