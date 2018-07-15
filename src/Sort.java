
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guy
 */
public class Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_2_munros.csv";
        
        List<Munro> munros = new MunroSorter
                .Builder(filepath)
                .build();
        
        for (Munro munro: munros) {
            System.out.println(munro);
        }
        
    }
    
}
