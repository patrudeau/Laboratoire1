import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.util.List;


import org.junit.Before;

import org.junit.Test;


public class TestCalculerDistance {
	
	private CSVReader reader = new CSVReader();
	private MathPA math = new MathPA();
	private List<Float> nombreListe;
	
	@Before
	public void setUp() throws Exception {
		nombreListe = reader.getNumberFromCSV("test.csv");
	}
	
	@Test
	public void testResult() {
		assertEquals(205118.43, math.calculerDistance(nombreListe,0),0.1);
	}
	
	@Test
	public void testEmpty() {
	  try {
			nombreListe = reader.getNumberFromCSV("testVide.csv");
			math.calculerDistance(nombreListe,0);
		    fail("Should throw exception");
		  }catch(IndexOutOfBoundsException exception){
		    assert(exception.getMessage().contains(""));
		  }
	}
	
	@Test
	public void testAlphaException(){
	  try {
		nombreListe = reader.getNumberFromCSV("testAlpha.csv");
		math.calculerDistance(nombreListe,0);
	    fail("Should throw exception");
	  }catch(NumberFormatException exception){
	    assert(exception.getMessage().contains(""));
	  }
	}
}
