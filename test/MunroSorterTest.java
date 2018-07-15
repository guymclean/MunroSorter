
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
    
    
    @Test
    public void testSortByHeightAscending() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_2_munros.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .sortByHeight('a')
                .build();
        
        Munro munro1 = new Munro("Ben Chonzie", (float) 931, "MUN", "NN773308");
        Munro munro2 = new Munro("Ben Vorlich", (float) 985, "MUN", "NN629189");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);
        expResult.add(munro2);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSortByHeightDescending() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_2_munros.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .sortByHeight('d')
                .build();
        
        Munro munro1 = new Munro("Ben Vorlich", (float) 985, "MUN", "NN629189");
        Munro munro2 = new Munro("Ben Chonzie", (float) 931, "MUN", "NN773308");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);
        expResult.add(munro2);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSortByNameAscending() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_2_munros.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .sortByName('a')
                .build();
        
        Munro munro1 = new Munro("Ben Chonzie", (float) 931, "MUN", "NN773308");
        Munro munro2 = new Munro("Ben Vorlich", (float) 985, "MUN", "NN629189");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);
        expResult.add(munro2);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSortByNameDescending() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_2_munros.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .sortByName('d')
                .build();
        
        Munro munro1 = new Munro("Ben Vorlich", (float) 985, "MUN", "NN629189");
        Munro munro2 = new Munro("Ben Chonzie", (float) 931, "MUN", "NN773308");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);
        expResult.add(munro2);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testFilterMinHeight() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_2_munros.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .minHeight(980)
                .build();
        
        Munro munro1 = new Munro("Ben Vorlich", (float) 985, "MUN", "NN629189");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testFilterMaxHeight() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_2_munros.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .maxHeight(980)
                .build();
        
        Munro munro1 = new Munro("Ben Chonzie", (float) 931, "MUN", "NN773308");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testFilterMinAndMaxHeightTogether() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_3_munros.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .minHeight(970)
                .maxHeight(980)
                .build();
        
        Munro munro1 = new Munro("Stuc a' Chroin", (float) 975, "MUN", "NN617174");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testFilterCategoryMunro() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_munro_and_top.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .filterCategory('m')
                .build();
        
        Munro munro1 = new Munro("Ben Chonzie", (float) 931, "MUN", "NN773308");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testFilterCategoryTop() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_munro_and_top.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .filterCategory('t')
                .build();
        
        Munro munro1 = new Munro("Stob Binnein - Stob Coire an Lochain", (float) 1068, "TOP", "NN438220");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testLimit() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_munro_and_top.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .limit(1)
                .build();

        assert(result.size() == 1);
    }
    
    
    @Test
    public void testSortByHeightAscendingThenNameAscending() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_duplicate_heights.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .sortByHeight('a')
                .sortByName('a')
                .build();
        
        Munro munro1 = new Munro("Ben Chonzie", (float) 931, "MUN", "NN773308");
        Munro munro2 = new Munro("Geal Charn", (float) 1049, "MUN", "NN504811");
        Munro munro3 = new Munro("Sgurr Fhuar-thuill", (float) 1049, "MUN", "NH235437");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);
        expResult.add(munro2);
        expResult.add(munro3);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSortByHeightAscendingThenNameDescending() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_duplicate_heights.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .sortByHeight('a')
                .sortByName('d')
                .build();
        
        Munro munro1 = new Munro("Ben Chonzie", (float) 931, "MUN", "NN773308");
        Munro munro2 = new Munro("Sgurr Fhuar-thuill", (float) 1049, "MUN", "NH235437");
        Munro munro3 = new Munro("Geal Charn", (float) 1049, "MUN", "NN504811");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);
        expResult.add(munro2);
        expResult.add(munro3);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSortByHeightDescendingThenNameAscending() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_duplicate_heights.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .sortByHeight('d')
                .sortByName('a')
                .build();
        
        Munro munro1 = new Munro("Geal Charn", (float) 1049, "MUN", "NN504811");
        Munro munro2 = new Munro("Sgurr Fhuar-thuill", (float) 1049, "MUN", "NH235437");
        Munro munro3 = new Munro("Ben Chonzie", (float) 931, "MUN", "NN773308");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);
        expResult.add(munro2);
        expResult.add(munro3);

        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSortByHeightDescendingThenNameDescending() {
        
        String filepath = "C:\\Users\\Guy\\Documents\\NetBeansProjects\\MunroSorter\\data\\munro_test_data_duplicate_heights.csv";

        List<Munro> result = new MunroSorter
                .Builder(filepath)
                .sortByHeight('d')
                .sortByName('d')
                .build();
        
        Munro munro1 = new Munro("Sgurr Fhuar-thuill", (float) 1049, "MUN", "NH235437");
        Munro munro2 = new Munro("Geal Charn", (float) 1049, "MUN", "NN504811");
        Munro munro3 = new Munro("Ben Chonzie", (float) 931, "MUN", "NN773308");

        List<Munro> expResult = new ArrayList<>();
        expResult.add(munro1);
        expResult.add(munro2);
        expResult.add(munro3);

        assertEquals(expResult, result);
    }
}
