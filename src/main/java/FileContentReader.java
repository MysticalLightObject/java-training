import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

public class FileContentReader {
    private static final Charset charset = Charset.forName("UTF-8");

    public static HashMap<String, Integer> readContents(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path, charset);
             Scanner scanner = new Scanner(reader)) {
            HashMap<String, Integer> wordsListWithAmount = new HashMap<>();
            FileContentReader.fillHashMap(scanner, wordsListWithAmount);
            return wordsListWithAmount;
        } catch (NoSuchFileException x) {
            System.out.println("File with path \"" + path.toString() + "\" not found!");
        } catch (IOException x) {
            System.out.println("Unknown error occured");
            System.err.println(x.toString());
        }
        return null;
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
