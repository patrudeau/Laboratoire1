import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class mainTP5 {

	public static void main(String[] args) {
		
		CSVReader reader = new CSVReader();
		MathPA math = new MathPA();
		List<Float> numberList = new ArrayList<Float>();

				
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files","csv");
		chooser.setFileFilter(filter);
		
		
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			numberList = reader.getNumberFromCSV(chooser.getSelectedFile().getPath());
		}
			System.out.println("Intervale supérieure : " + math.calculerIntervaleSup(numberList));
			System.out.println("Intervale inférieur : " + math.calculerIntervaleInf(numberList));
			
	}

}
