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
            System.out.println("Unknown error has occurred");
            System.err.println(x.toString());
        }
        return null;
    }

    private static HashMap<String, Integer> fillHashMap(Scanner scanner, HashMap<String, Integer> mapTo) {
        Integer amount;

        while (scanner.hasNext()) {
            String word = scanner.next();
            String normalizedWord = trim(word);
            if (mapTo.containsKey(normalizedWord)) {
                amount = mapTo.get(normalizedWord) + 1;
                mapTo.put(normalizedWord, amount);
            }
            else
                mapTo.put(normalizedWord, 1);
        }
        return mapTo;
    }

    private static String trim(String wordToTrim) {
        return wordToTrim.replaceAll("[^a-zA-Z0-9’]+", "").toLowerCase();
    }
}
