import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.util.List;


import org.junit.Before;

import org.junit.Test;


public class TestCalculerEcartType {
	
	private CSVReader reader = new CSVReader();
	private MathPA math = new MathPA();
	private List<Float> nombreListe;
	
	@Before
	public void setUp() throws Exception {
		nombreListe = reader.getNumberFromCSV("test.csv");
	}
	
	@Test
	public void testResult() {
		assertEquals(625.634, math.calculerEcartType(nombreListe),0.1);
	}
	
	@Test
	public void testEmpty() {
		nombreListe = reader.getNumberFromCSV("testVide.csv");
		assertEquals(0, math.calculerEcartType(nombreListe),0);
	}
	
	@Test
	public void testAlphaException(){
	  try {
		nombreListe = reader.getNumberFromCSV("testAlpha.csv");
	    math.calculerEcartType(nombreListe);
	    fail("Should throw exception");
	  }catch(NumberFormatException exception){
	    assert(exception.getMessage().contains(""));
	  }
	}
}
