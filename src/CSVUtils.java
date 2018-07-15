
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Guy
 */
public class CSVUtils {
    
    
    private static Munro createMunroFromString(
            List<String> munroData,
            int nameIndex,
            int heightInMetersIndex,
            int hillCategoryIndex,
            int gridRefIndex) {
        String name = munroData.get(nameIndex);
        float heightInMeters = Float.valueOf(munroData.get(heightInMetersIndex));
        String hillCategory = munroData.get(hillCategoryIndex);
        String gridRef = munroData.get(gridRefIndex);
        Munro munro = new Munro(name, heightInMeters, hillCategory, gridRef);
        return munro;
    }
        
        
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
    
    
    static List<Munro> readMunrosFromFile(String filepath) {

        ArrayList<Munro> munros = new ArrayList<>();
        String csvLine = "";
        char delimeter = ',';

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

            String firstLine = br.readLine();
            String[] columnTitles = firstLine.split(String.valueOf(delimeter));
            List<String> columnNames = Arrays.asList(columnTitles);

            int nameIndex = columnNames.indexOf("Name");
            int heightInMetersIndex = columnNames.indexOf("Height (m)");
            int hillCategoryIndex = columnNames.indexOf("Post 1997");
            int gridRefIndex = columnNames.indexOf("Grid Ref");

            while ((csvLine = br.readLine()) != null) {
                List<String> munroData = CSVUtils.parseLine(csvLine, delimeter);

                try {
                    Munro munro = createMunroFromString(
                            munroData,
                            nameIndex,
                            heightInMetersIndex,
                            hillCategoryIndex,
                            gridRefIndex);
                    if (!munro.getHillCategory().equals("")) {
                        munros.add(munro);
                    }
                }
                catch (Exception e) {
                    continue;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return munros;        
    }
}
