import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.junit.Before;

import org.junit.Test;


public class TestTp4 {
	
	private CSVReader reader = new CSVReader();
	private MathPA math = new MathPA();
	private ArrayList<ArrayList<Float>> listOfNumber;
	ArrayList<Float> correlationList = new ArrayList<Float>();
	
	@Before
	public void setUp() throws Exception {
		listOfNumber = reader.getListOfNumberFromCSV(new File("testTp4.csv"));
		for(ArrayList<Float> numberList : listOfNumber) {
			ArrayList<Float> sommationList = new ArrayList<Float>();
			correlationList.add(numberList.remove(numberList.size()-1));
			for(int i = 0; i < numberList.size();i++) {
				sommationList.add(numberList.get(i));
			}
				
			correlationList.add(math.calculerSomme(sommationList));
		}
	}
	
	@Test
	public void testResult() {
		assertEquals(0.155216, math.calculerCorrelation(correlationList),0.00001);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testEmpty() {
		listOfNumber = reader.getListOfNumberFromCSV(new File("testVideTp4.csv"));
		for(ArrayList<Float> numberList : listOfNumber) {
			if(numberList.size() < 1) {
				throw new ArrayIndexOutOfBoundsException("La liste est vide!");
			}
			else {
				ArrayList<Float> sommationList = new ArrayList<Float>();
				correlationList.add(numberList.remove(numberList.size()-1));
				for(int i = 0; i < numberList.size();i++) {
					sommationList.add(numberList.get(i));
				}
					
				correlationList.add(math.calculerSomme(sommationList));
			}
		}
	}
	
	@Test
	public void testNoLink(){
		listOfNumber = reader.getListOfNumberFromCSV(new File("testAucunLien.csv"));
		for(ArrayList<Float> numberList : listOfNumber) {
			ArrayList<Float> sommationList = new ArrayList<Float>();
			correlationList.add(numberList.remove(numberList.size()-1));
			for(int i = 0; i < numberList.size();i++) {
				sommationList.add(numberList.get(i));
			}
				
			correlationList.add(math.calculerSomme(sommationList));
		}
		assertEquals(0.5628567, math.calculerCorrelation(correlationList),0.000001);
	}
}