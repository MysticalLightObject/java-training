import java.nio.file.Path;
import java.util.HashMap;

public class TopWordsLurker {

    public static void main(String[] args) {
        Path path = ConsoleInputReader.readPath();
        HashMap<String, Integer> wordsWithAmounts = FileContentReader.readContents(path);

        //todo: 1) switch key-value to value-key for every entry of the map and put it into the TreeMap structure
        //todo: 2) trim redundant chars and symbols around the words
        //todo: 3) normalize the words to the lowercase
        System.out.println(wordsWithAmounts);
    }


}
