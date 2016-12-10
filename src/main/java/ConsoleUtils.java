import java.io.Console;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;

public class ConsoleUtils {

    public static Path readPath() {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        String stringPath = c.readLine("Please, enter the file path(relative or absolute)\n");
        return Paths.get(stringPath);
    }

    public static void outputTopWords(NavigableMap<Integer, ArrayList<String>> map) {
        Iterator it = map.entrySet().iterator();
        int counter = 0;

        while (it.hasNext() && counter < 10) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(counter + 1 + ")" + "\nAmount: " + pair.getKey() + "\nWords list: " + pair.getValue());
            counter++;
        }
    }
}
