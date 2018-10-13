import java.io.BufferedReader;
import java.util.List;

public class main {

	public static void main(String[] args) {
		
		CSVReader reader = new CSVReader();
		MathPA math = new MathPA();
		
		List<Float> nombreListe = reader.getNumberFromCSV("test.csv");
		
		System.out.print("Données : ");
		for(float nombre : nombreListe) {
			System.out.print(nombre + ", ");
		}
		
		System.out.println("Moyenne : " + math.calculerMoyenne(nombreListe));
		
		System.out.println("Variance : " + math.calculerVariance(nombreListe));
		
		System.out.println("Écart type : " + math.calculerEcartType(nombreListe));
		
	}

}