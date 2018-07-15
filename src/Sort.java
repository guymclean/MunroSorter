
import java.util.List;

/**
 *
 * @author Guy
 */
public class Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_data.csv";
        
        List<Munro> munros = new MunroSorter
                .Builder(filepath)
                .sortByHeight('a')
                .sortByName('d')
                .minHeight(1048)
                .maxHeight(1050)
                .filterCategory('m')
//                .limit(10)
                .build();
        
        for (Munro munro: munros) {
            System.out.println(munro);
        }
        
    }
    
}
