import java.io.BufferedReader;
import java.io.IOException;
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
				
				nombre.add(Float.valueOf(ligne));
				
				ligne = breader.readLine();
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return nombre;
	}
	
}

