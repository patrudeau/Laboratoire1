import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	public List<Float> getNumberFromCSV(String path){
		List<Float> nombre = new ArrayList<Float>();
		Path pathCSV = Paths.get(path);
		
		try {
			BufferedReader breader = Files.newBufferedReader(pathCSV);
			
			String ligne = breader.readLine();
			
			//Skip la premiere ligne
			ligne = breader.readLine();
			
			while(ligne != null) {
				String[] rowNumber = ligne.split("\\;");
				
				for(String number : rowNumber) {
					
					nombre.add(Float.valueOf(number.replace(",", ".")));
				}
				ligne = breader.readLine();
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return nombre;
	}
	
	public ArrayList<ArrayList<Float>> getListOfNumberFromCSV(File file){
		ArrayList<ArrayList<Float>> listOfNumber = new ArrayList<ArrayList<Float>>();
		
		System.out.println(file.getPath());

		try {
			BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath()),"utf-8"));;
			
			String ligne = breader.readLine();
			
			while(ligne != null) {
				ArrayList<Float> numberList = new ArrayList<Float>();
				
				String[] rowNumber = ligne.split("\\;");
				
				for(int i = 1; i< rowNumber.length;i++) { 
					numberList.add(Float.valueOf(rowNumber[i].replace(",", ".")));
				}
				listOfNumber.add(numberList);
				ligne = breader.readLine();
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listOfNumber;
	}
	
}

