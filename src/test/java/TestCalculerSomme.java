import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCalculerSomme {
	
	private CSVReader reader = new CSVReader();
	private List<Float> nombreListe;
	
	@Before
	public void setUp() throws Exception {
		nombreListe = reader.getNumberFromCSV("test.csv");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		System.out.println(nombreListe);
	}

}
