import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileParser {
    private static String readFile(String path)
    {
        if (!Files.exists(Path.of(path)))
        {
            System.out.println("Report for month " + getMonthName(path) + " doesn't exist");
            return null;
        }

        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static String[] getLinesFromFile(String path) {
        if (readFile(path) == null) {
            return null;
        }
        return readFile(path).split("\n");
    }

    public static String getMonthName(String path) {
        return path.substring(path.length() - 6, path.length() - 4);
    }

    public static String getYearName(String path) {
        return path.substring(path.length() - 8, path.length() - 4);
    }
}
