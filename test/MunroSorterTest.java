
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guy
 */
public class MunroSorterTest {
    
    public MunroSorterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testReadMunrosFromFile() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_2_munros.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .build();
        
        Munro munro1 = new Munro("Ben Chonzie", (float) 931, "MUN", "NN773308");
        Munro munro2 = new Munro("Ben Vorlich", (float) 985, "MUN", "NN629189");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);
        expResult.add(munro2);

        assertEquals(expResult, result);
    }
    
}
