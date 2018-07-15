/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
        munros = readMunrosFromFile(filepath); 
        this.categoryToFilter = categoryToFilter;
        this.limit = limit;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.nameSortParam = nameSortParam;
        this.heightSortParam = heightSortParam;
    }
    
    
    private Munro createMunroFromString(
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
    
    
    private List<Munro> getMunros(){
        return munros;
    }
    
    
    private void print(){
        for (Munro munro: munros) {
            System.out.println(munro);
        }
    }
    
    
    private List<Munro> readMunrosFromFile(String filepath) {

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
                    Munro munro = this.createMunroFromString(
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
