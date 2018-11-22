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
		List<Float> x = getColumn(nombreList, 0, 2);
		List<Float> y = getColumn(nombreList, 1, 2);		
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
	
	public String calculerRegression(List<Float> nombreList) {
		List<Float> x = getColumn(nombreList, 0, 2);
		List<Float> y = getColumn(nombreList, 1, 2);	
		float moyX = calculerMoyenne(x);
		float moyY = calculerMoyenne(y);
		float sommeXY = 0;
		float sommeXX = 0;
		for(int j = 0; j < x.size(); j++) {
			sommeXY += x.get(j)*y.get(j);
			sommeXX += x.get(j)*x.get(j);
		}
		float B1 = (sommeXY - x.size()*moyX*moyY)/(sommeXX-(x.size()*moyX*moyX));
		float B0 = moyY - B1*moyX;
		
		return "" + B1 +"x + " + B0;
	}
	
	/*
	 * This method return a column base on the number of column in the List
	 * --Note that the first column start with a 0--
	 */
	public List<Float> getColumn(List<Float> nombreList, int col, int nbCol){
		
		List<Float> column = new ArrayList<Float>();
		int i = 0;
		for(float nombre : nombreList) {
			if(i%nbCol == col) {
				column.add(nombre);
			}
			i++;
		}
		return column;
	}
	
	public String confirmCorrelation (double correl) {
		String text;
		if (correl > 0.5) { 
			text = "Il existe une corrélation entre ces deux éléments";
		}
		else {
			text = "Il n'existe pas de corrélation entre ces deux éléments";
		}
		return text;
	}
}
