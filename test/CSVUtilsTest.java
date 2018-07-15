/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class CSVUtilsTest {

    @Test
    public void testParseLine() {
        String line = "1,5,\"http://www.streetmap.co.uk/324,730\",10.9";
        
        List<String> expResult = new ArrayList<>();
        expResult.add("1");
        expResult.add("5");
        expResult.add("http://www.streetmap.co.uk/324,730");
        expResult.add("10.9");
        
        List<String> result = CSVUtils.parseLine(line, ',');
        
        assertEquals(expResult, result);
    }
    
}
