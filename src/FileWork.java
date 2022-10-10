import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWork {
    private String readFileContentsOrNull(String path)
    {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public String[] getLine(String path) {
        return readFileContentsOrNull(path).split(System.lineSeparator());
    }

    public String getMonthFromFileName(String name) {
        return name.substring(name.length() - 6, name.length() - 4);
    }

    public String getYearFromFileName(String name) {
        return name.substring(name.length() - 8, name.length() - 4);
    }
}
