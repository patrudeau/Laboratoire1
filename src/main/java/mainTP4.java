import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class mainTP4 {

	public static void main(String[] args) {
		
		CSVReader reader = new CSVReader();
		MathPA math = new MathPA();
		ArrayList<ArrayList<Float>> listOfNumber = new ArrayList<ArrayList<Float>>();
		ArrayList<Float> correlationList = new ArrayList<Float>();

				
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files","csv");
		chooser.setFileFilter(filter);
		
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			listOfNumber = reader.getListOfNumberFromCSV(chooser.getSelectedFile());
		}
		for(ArrayList<Float> numberList : listOfNumber) {
			ArrayList<Float> sommationList = new ArrayList<Float>();
			correlationList.add(numberList.remove(numberList.size()-1));
			for(int i = 0; i < numberList.size();i++) {
				
				sommationList.add(numberList.get(i));
			}
			correlationList.add(math.calculerSomme(sommationList));
			
		}
		System.out.println("La corrélation : " + math.calculerCorrelation(correlationList));
		System.out.println(math.confirmCorrelation(math.calculerCorrelation(correlationList)));
	}

}
