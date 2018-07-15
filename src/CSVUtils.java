
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guy
 */
public class CSVUtils {
    public static List<String> parseLine(String csvLine, char delimeter) {
        
        List result = new ArrayList<>();
        StringBuilder currentValue = new StringBuilder();
        boolean inQuotes = false;
        
        char[] chars = csvLine.toCharArray();
        
        int counter = 0;
        for (char ch : chars) {
            if (ch == '"') {
                inQuotes ^= true;
            }
            else if (ch == delimeter && !inQuotes) {
                result.add(currentValue.toString());
                currentValue = new StringBuilder();
                
            }
            else {
                currentValue.append(ch);
            }
            if (counter++ == chars.length-1) { // last character
                result.add(currentValue.toString());
            }
        }
        return result;
    }
}
