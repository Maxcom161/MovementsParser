import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String path = "data/movementList.csv";
        String regex = "[^a-zA-Z0-9]([a-zA-Z0-9\\s]+)[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}" +
                "\\s[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}";
        HashMap<String, Double> list = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.remove(lines.get(0));

            for (String line : lines) {
                String[] components = line.split(",");
                if (components.length != 8) {
                    continue;
                }
                String result = components[5];
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(result);
                result = matcher.find() ? matcher.group(1).trim() : "";
                if (list.containsKey(result)) {
                    list.put(result, list.get(result) + Double.valueOf(components[7]));
                    continue;
                }
                list.put(result, Double.valueOf(components[7]));

            }
            for (String key : list.keySet()) {
                System.out.println(key + "\t" + list.get(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
