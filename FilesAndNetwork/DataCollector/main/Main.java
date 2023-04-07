import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WebParser metroMoscow = new WebParser("https://skillbox-java.github.io/");
        metroMoscow.parseLinesAndStations("data/export8.json");
        System.out.println(metroMoscow);


    }
}
