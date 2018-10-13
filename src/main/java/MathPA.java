import java.util.ArrayList;
import java.util.List;

public class MathPA {

	public float calculerMoyenne(List<Float> nombreListe) {
		return calculerSomme(nombreListe)/nombreListe.size();
	}
	
	public float calculerEcartType(List<Float> nombreListe) {
		return (float) Math.sqrt(calculerVariance(nombreListe));
	}
	
	public float calculerSomme(List<Float> nombreListe) {
		
		float somme = 0;
		for(float nombre : nombreListe) {
			somme += nombre;
		}
		return somme;
	}
	
	public float calculerDistance(List<Float> nombreListe, int index) {
		float x = nombreListe.get(index);
		float moyenne = calculerMoyenne(nombreListe);
		return (x-moyenne)*(x-moyenne);
	}
	
	public float calculerVariance(List<Float> nombreListe) {
		
		float somme = 0;
		int i = 0;
		for(float nombre : nombreListe) {
			somme += calculerDistance(nombreListe, i);
			i++;
		}
		return somme/(nombreListe.size()-1);
	}
}
