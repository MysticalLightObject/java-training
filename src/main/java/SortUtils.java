import java.util.*;

public class SortUtils {

    public static NavigableMap<Integer, ArrayList<String>> getSortedWordMap(HashMap<String, Integer> content) {
        TreeMap<Integer, ArrayList<String>> treeMap = new TreeMap<>();
        if (content != null) {
            for (Map.Entry<String, Integer> entry : content.entrySet()) {
                String word = entry.getKey();
                Integer amount = entry.getValue();

                if (treeMap.containsKey(amount)) {
                    ArrayList<String> wordList = treeMap.get(amount);
                    wordList.add(word);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(word);
                    treeMap.put(amount, list);
                }
            }
        }
        return treeMap.descendingMap();
    }
}
