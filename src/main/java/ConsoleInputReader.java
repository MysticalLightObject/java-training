import java.io.Console;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConsoleInputReader {

    public static Path readPath() {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        String stringPath = c.readLine("Please, enter the file path(relative or absolute)\n");
        return Paths.get(/*stringPath*/"/home/mike/IdeaProjects/TopWordsLurker/src/main/resources/text");
    }
}
