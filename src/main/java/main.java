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
		System.out.println("");
		System.out.println("Somme : " + math.calculerSomme(nombreListe));
		System.out.println("Moyenne : " + math.calculerMoyenne(nombreListe));
		System.out.println("Variance : " + math.calculerVariance(nombreListe));	
		System.out.println("Écart type : " + math.calculerEcartType(nombreListe));
		System.out.println("Distance avec 0 : " + math.calculerDistance(nombreListe, 0));
		
		System.out.println("Cette section est faite avec le csv du tp2");
		nombreListe = reader.getNumberFromCSV("testTp2.csv");
		
		System.out.println("Corrélation : " + math.calculerCorrelation(nombreListe));
		System.out.println("Corrélation au carrée : " + math.calculerCorrelation(nombreListe)*math.calculerCorrelation(nombreListe));
	}

}