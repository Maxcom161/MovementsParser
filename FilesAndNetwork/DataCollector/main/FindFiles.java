import java.io.File;
import java.util.ArrayList;

public class FindFiles {

    private final ArrayList<File> listFiles;

    public FindFiles() {
        this.listFiles = new ArrayList<>();

    }

    public ArrayList<File> startSearch(String path) {
        File file = new File(path);
        if(file.isDirectory()) {
            for(File directory : file.listFiles()){
                startSearch(directory.getAbsolutePath());
                if(directory.getAbsolutePath().endsWith(".csv") ||
                directory.getAbsolutePath().endsWith(".json")) {
                    listFiles.add(directory);
                }
            }
        }
      return listFiles;
    }

    public ArrayList<File> getListFiles() {
        return listFiles;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        listFiles.forEach(s->stringBuilder.append(s + "\n"));
        return stringBuilder + "";
    }
}
