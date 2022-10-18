import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileParser {
    private static String readFile(String path)
    {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static String[] getLinesFromFile(String path) {
        if (!isExist(path)) {
            return new String[0];
        }
        return readFile(path).split("\n");
    }

    private static boolean isExist(String path) {
        return Files.exists(Path.of(path));
    }
}
