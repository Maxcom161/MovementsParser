import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CsvParce {
    int flaq = 0;

    JsonParce jsonParce = new JsonParce();
    FindFiles files = new FindFiles();
    HashMap<String, MetroStation> listTreeParametersStation = new HashMap<>(jsonParce.getList());

    public HashMap<String, MetroStation> getListTreeParametersStation() {
        return listTreeParametersStation;
    }

    List<MetroStation> stations;

    public CsvParce() throws IOException {
        stations = new ArrayList<>();
        parceCsv();
    }


    public List<MetroStation> getListStations() {
        return stations;
    }


    public void parceCsv() throws IOException {
        List<File> filesFind = files.startSearch("C:/Users/Admin/Desktop/stations-data");
        for(File fileCsv : filesFind) {
            if (!fileCsv.getAbsolutePath().endsWith(".csv")) {
                continue;
            }
            List<String> linesCsv = Files.readAllLines(Paths.get(fileCsv.getAbsolutePath()));
            linesCsv.remove(0);
            for(String line : linesCsv) {
                String[] elements = line.split(",");
                if(elements.length!=2) {
                    System.out.println("Ошибка считывания csv файла");
                    continue;
                }
                String nameStation = elements[0];
                String dateStation = elements[1];
                listTreeParametersStation.keySet().forEach(s -> {
                    if (s.equalsIgnoreCase(nameStation)) {
                        MetroStation metroStation = listTreeParametersStation.get(s);
                        if (metroStation.getOpeningDate() != null &&
                                !(metroStation.getOpeningDate().equals(dateStation))) {
                            MetroStation metroStationNew = new MetroStation(nameStation, metroStation.getMetroLine());
                            metroStationNew.setDepth(null);
                            metroStationNew.setOpeningDate(dateStation);
                            stations.add(metroStationNew);
                            flaq++;
                        } else {
                            metroStation.setOpeningDate(dateStation);
                            stations.add(metroStation);
                        }

                    }
                });
            }
        }
    }


    public int getFlaq() {
        return flaq;
    }




    public String getCsvFiles(String path) {
        return "";
    }




}
