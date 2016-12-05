import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TopWordsLurker {
    private final Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) {
        TopWordsLurker wordsLurker = new TopWordsLurker();
        Path path = Paths.get(/*wordsLurker.readPath()*/"/home/mike/IdeaProjects/TopWordsLurker/src/main/resources/text");
        wordsLurker.readContents(path);
    }

    private void readContents(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path, charset);
                Scanner scanner = new Scanner(reader)) {
            HashMap<String, Integer> wordsListWithAmount = new HashMap<>();
            TopWordsLurker.fillHashMap(scanner, wordsListWithAmount);
            System.out.println(wordsListWithAmount);
        } catch (NoSuchFileException x) {
            System.out.println("File with path \"" + path.toString() + "\" not found!");
        } catch (IOException x) {
            System.out.println("Unknown error occured");
            System.err.println(x.toString());
        }
    }

    private String readPath() {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        return c.readLine("Please, enter the file path(relative or absolute)\n");
    }

    private static HashMap<String, Integer> fillHashMap(Scanner scanner, HashMap<String, Integer> mapTo) {
        Integer amount;

        while (scanner.hasNext()) {
            String word = scanner.next();
            if (mapTo.containsKey(word)) {
                amount = mapTo.get(word) + 1;
                mapTo.put(word, amount);
            }
            else
                mapTo.put(word, 1);
        }
        return mapTo;
    }
}
