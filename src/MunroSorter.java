
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Guy
 */
public class MunroSorter { 
    
    List<Munro> munros;
    private char categoryToFilter;
    private int limit;
    private int maxHeight;
    private int minHeight;
    private char nameSortParam;
    private char heightSortParam;
    
    
    private MunroSorter(
            String filepath,
            char categoryToFilter,
            int limit,
            int minHeight,
            int maxHeight,
            char nameSortParam,
            char heightSortParam) {
        munros = CSVUtils.readMunrosFromFile(filepath); 
        this.categoryToFilter = categoryToFilter;
        this.limit = limit;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.nameSortParam = nameSortParam;
        this.heightSortParam = heightSortParam;
        applyFilters();
    }
    
    
    private void applyFilters() {
        
        boolean sortedByHeight = false;
        
        if (categoryToFilter != 'x') {
            filterCategory(categoryToFilter);
        }
        if (maxHeight > -1) {
            if (maxHeight < minHeight) {
                System.out.println("Max height filter is smaller than min height filter and has not been applied");
            }
            else {
                filterMaxHeight(maxHeight);
            }
        }
        if (minHeight > -1) {
            if (minHeight > maxHeight && maxHeight != -1) {
                System.out.println("Min height filter is greater than max height filter and has not been applied");
            }
            else {
                filterMinHeight(minHeight);
            }
        }
        if (heightSortParam != 'x') {
            sortByHeight(heightSortParam);
            sortedByHeight = true;
        }
        if (nameSortParam != 'x') {
            if (!sortedByHeight) {
                sortByName(nameSortParam);
            }
            else {
                sortSecondaryByName(nameSortParam);
            }
        }        
        if (limit > 0) {
            limitBy(limit);
        }
    }
  
    
    public void filterCategory(char filterOption) {
        if (filterOption == 't') {
            munros.removeIf(munro -> munro.getHillCategory().equals("MUN"));
        }
        else {
            munros.removeIf(munro -> munro.getHillCategory().equals("TOP"));
        }
    }
    
    
    public void filterMaxHeight(int maxHeight) {
        munros.removeIf(munro -> munro.getHeightInMeters() > maxHeight);
    }
    
    
    public void filterMinHeight(int minHeight) {
        munros.removeIf(munro -> munro.getHeightInMeters() < minHeight);
    }
    
    
    private List<Munro> getMunros(){
        return munros;
    }
    
    
    public void limitBy(int limit) {
        if (limit < munros.size()) {
            munros = munros.subList(0, limit);
        }
    }
        
    
    private void print(){
        for (Munro munro: munros) {
            System.out.println(munro);
        }
    }
    
    
    public void sortByHeight(char sortParam) {
        Collections.sort(munros, new Munro.HeightComparator());
        if (sortParam == 'd') {
            Collections.reverse(munros);
        }
    }
    
    
    public void sortByName(char sortParam) {
        Collections.sort(munros, new Munro.NameComparator());
        if (sortParam == 'd') {
            Collections.reverse(munros);
        }
    }
    
    
    private void sortSecondaryByName(char sortParam) {
        // look for duplicates in height
//        sort or swap list items

        int startOfDuplicatesIndex = -1;
        int endOfDuplicatesIndex = -1;
        float duplicateHeight;
        

        for (int i=0; i<munros.size()-1; i++) {
            float thisHeight = munros.get(i).getHeightInMeters();
            float nextHeight = munros.get(i+1).getHeightInMeters();
            if (thisHeight == nextHeight) {
                if (startOfDuplicatesIndex == -1) {
                    startOfDuplicatesIndex = i;
                }
                endOfDuplicatesIndex = i+1;
            }
            else {
                if (startOfDuplicatesIndex != -1) {
                    sortDuplicateHeightsByName(
                            startOfDuplicatesIndex,
                            endOfDuplicatesIndex
                    );
                    startOfDuplicatesIndex = -1;
                    endOfDuplicatesIndex = -1;
                }
            }
            if (i == munros.size()-2 && startOfDuplicatesIndex != -1) {
                sortDuplicateHeightsByName(
                        startOfDuplicatesIndex,
                        endOfDuplicatesIndex
                );
            }
        }
    }
    
    
    private void sortDuplicateHeightsByName(
            int startOfDuplicatesIndex, 
            int endOfDuplicatesIndex) {
        Collections.sort(
                munros.subList(startOfDuplicatesIndex, endOfDuplicatesIndex+1),
                new Munro.NameComparator()
        );
        if (nameSortParam == 'd') {
            Collections.reverse(munros.subList(startOfDuplicatesIndex, endOfDuplicatesIndex+1));
        }
        
    }
    
    
    public static class Builder {
        
        private String filepath;
        private char categoryToFilter;
        private int limit;
        private int minHeight;
        private int maxHeight;
        private char nameSortParam;
        private char heightSortParam;
        
        
        public Builder(String filepath) {
            this.filepath = filepath;
            categoryToFilter = 'x';
            limit = -1;
            maxHeight = -1;
            minHeight = -1;
            nameSortParam = 'x';
            heightSortParam = 'x';
        }
        
        
        public Builder filterCategory(char filterOption) {
            this.categoryToFilter = filterOption;
            return this;
        }
        
        
        public Builder limit(int limit) {
            this.limit = limit;
            return this;
        }
        
        
        public Builder maxHeight(int maxHeight) {
            this.maxHeight = maxHeight;
            return this;
        }
        
        
        public Builder minHeight(int minHeight) {
            this.minHeight = minHeight;
            return this;
        }
      
        
        public Builder sortByName(char sortParam) {
            this.nameSortParam = sortParam;
            return this;
        }


        public Builder sortByHeight(char sortParam) {
            this.heightSortParam = sortParam;
            return this;
        }
        
        
        public List<Munro> build() { 
            MunroSorter munroSorter = new MunroSorter(
                    filepath,
                    categoryToFilter,
                    limit,
                    minHeight,
                    maxHeight,
                    nameSortParam,
                    heightSortParam
            );
            return munroSorter.getMunros();
        }
    }
}
