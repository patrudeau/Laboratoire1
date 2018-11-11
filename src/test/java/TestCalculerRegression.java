import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.util.List;


import org.junit.Before;

import org.junit.Test;


public class TestCalculerRegression {
	
	private CSVReader reader = new CSVReader();
	private MathPA math = new MathPA();
	private List<Float> nombreListe;
	
	@Before
	public void setUp() throws Exception {
		nombreListe = reader.getNumberFromCSV("testTp3.csv");
	}
	
	@Test
	public void testResult() {
		assertEquals("1.7279323x + -22.55243", math.calculerRegression(nombreListe));
	}
	
	@Test
	public void testEmpty() {
		nombreListe = reader.getNumberFromCSV("testVide.csv");
		assertEquals(""+Double.NaN+"x + "+Double.NaN, math.calculerRegression(nombreListe));
	}
	
	@Test
	public void testAlphaException(){
	  try {
		nombreListe = reader.getNumberFromCSV("testAlpha.csv");
	    math.calculerRegression(nombreListe);
	    fail("Should throw exception");
	  }catch(NumberFormatException exception){
	    assert(exception.getMessage().contains(""));
	  }
	}
}