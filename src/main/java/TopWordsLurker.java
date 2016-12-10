import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NavigableMap;

public class TopWordsLurker {

    public static void main(String[] args) {
        Path path = ConsoleUtils.readPath();
        HashMap<String, Integer> wordsWithAmountsMap = FileContentReader.readContents(path);
        NavigableMap<Integer, ArrayList<String>> sortedWordMap = SortUtils.getSortedWordMap(wordsWithAmountsMap);
        ConsoleUtils.outputTopWords(sortedWordMap);
    }


}
