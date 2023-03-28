import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {

        HashSet<String> listLinks = new HashSet<>();
        int number = 1;



        String url = "https://skillbox.ru/";
        Document doc = Jsoup.connect(url).get();
        Elements images = doc.select("img");

        for (Element image : images) {
            String link = image.attr("abs:src");
            if (link.isEmpty()) {
                continue;
            }
           listLinks.add(link);
        }
        for (String link : listLinks) {
            String filePath = "data/" + number++ + "." + getParseExtension(link);

            try {
                download(link, filePath);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

//            System.out.println(link + " -> " + filePath);

        }

    }
    private static void download(String link, String path) {

        try {
            URLConnection connection = new URL(link).openConnection();
            InputStream inStream = connection.getInputStream();
            FileOutputStream outStream = new FileOutputStream(path);
            int i;
            while ((i = inStream.read()) != -1) { //todo читаем стрим
                outStream.write(i); //todo записываем стрим
            }
            outStream.flush();
            outStream.close();
            inStream.close();

        } catch (IOException e) {
            System.out.println("Couldn't download " + link);
        }

    }

    private static String getParseExtension(String link) {
        String extension = link.replaceAll("^.+\\.", "")
                .replace("?.+$", "");
        Pattern pattern = Pattern.compile(extension);
        Matcher matcher = pattern.matcher(link);
        return matcher.find() ? matcher.group().trim() : "";
    }
}
