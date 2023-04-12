import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        WebParser metroMoscow = new WebParser("https://skillbox-java.github.io/");
        System.out.println(metroMoscow);



        CsvParce csvParce = new CsvParce();
        System.out.println(metroMoscow.getListStations().size() + " -   Количество станций после работы класса WebParser");
        System.out.println(csvParce.getListTreeParametersStation().size() + " Количество станций после работы класса JSON");
        System.out.println(csvParce.getListStations().size() + " -   Количество станций после работы класса CSV");
        System.out.println(csvParce.getListStations() + " -   Список объектов после установления даты открытия");
        System.out.println(csvParce.getFlaq() + " -  Количество новых станций созданных в классе CSV");


    }

    public static void downloadFile(ArrayList<File> files) throws IOException {
        int n = 1;
        for (File file : files) {

            int index = file.getAbsolutePath().lastIndexOf(".");
            String extension = file.getAbsolutePath().substring(index + 1);
            String filePath = "DataCollector/resource/" + n++ + "." + extension;
            FileReader fileReader = new FileReader(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    new FileOutputStream(filePath), StandardCharsets.UTF_8);
            int i;
            while ((i = fileReader.read())!=-1) {
                outputStreamWriter.write(i);
            }
            outputStreamWriter.flush();
            outputStreamWriter.close();
        }
    }

}

