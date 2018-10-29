import java.util.ArrayList;
import java.util.List;

public class MathPA {

	public float calculerMoyenne(List<Float> nombreListe) {
		return (nombreListe.size() > 0) ? calculerSomme(nombreListe)/nombreListe.size() : 0;
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
	public double calculerCorrelation(List<Float> nombreList) {
		List<Float> x = new ArrayList<Float>();
		List<Float> y = new ArrayList<Float>();		
		int i = 0;
		for(float nombre : nombreList) {
			if(i%2 == 0) {
				x.add(nombre);
			}
			else {
				y.add(nombre);
			}
			i++;
		}
		float moyX = calculerMoyenne(x);
		float moyY = calculerMoyenne(y);
		float numerateur = 0;
		float sommeDistanceX = 0;
		float sommeDistanceY = 0;
		for(int j = 0; j < x.size(); j++) {
			numerateur += (x.get(j)-moyX)*(y.get(j)-moyY);
			sommeDistanceX += calculerDistance(x,j);
			sommeDistanceY += calculerDistance(y,j);
		}
		return numerateur/(Math.sqrt(sommeDistanceX)*Math.sqrt(sommeDistanceY));
	}
}
