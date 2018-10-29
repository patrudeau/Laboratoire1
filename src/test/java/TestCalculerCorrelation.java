import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.util.List;


import org.junit.Before;

import org.junit.Test;


public class TestCalculerCorrelation {
	
	private CSVReader reader = new CSVReader();
	private MathPA math = new MathPA();
	private List<Float> nombreListe;
	
	@Before
	public void setUp() throws Exception {
		nombreListe = reader.getNumberFromCSV("testTp2.csv");
	}
	
	@Test
	public void testResult() {
		assertEquals(0.95592, math.calculerCorrelation(nombreListe),0.00001);
	}
	
	@Test
	public void testEmpty() {
		nombreListe = reader.getNumberFromCSV("testVide.csv");
		assertEquals(Double.NaN, math.calculerCorrelation(nombreListe),0);
	}
	
	@Test
	public void testAlphaException(){
	  try {
		nombreListe = reader.getNumberFromCSV("testAlpha.csv");
	    math.calculerCorrelation(nombreListe);
	    fail("Should throw exception");
	  }catch(NumberFormatException exception){
	    assert(exception.getMessage().contains(""));
	  }
	}
}