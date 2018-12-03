import java.util.ArrayList;
import java.util.List;

public class MathPA {
	
	public static int INTERVALE_LOC = 900;
	public static double STUDENT_90 = 1.860;
	public static double STUDENT_70 = 1.108;

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
		
		float B1 = calculerB1(nombreList);
		float B0 = calculerB0(nombreList);
		
		return "" + B1 +"x + " + B0;
	}
	public float calculerB1(List<Float> nombreList) {
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
		return (sommeXY - x.size()*moyX*moyY)/(sommeXX-(x.size()*moyX*moyX));
	}
	
	public float calculerB0(List<Float> nombreList) {
		List<Float> x = getColumn(nombreList, 0, 2);
		List<Float> y = getColumn(nombreList, 1, 2);	
		float moyX = calculerMoyenne(x);
		float moyY = calculerMoyenne(y);
		
		return moyY - calculerB1(nombreList)*moyX;
	}
	
	public List<Float> createListYRegression(List<Float> nombreList) {
		List<Float> x = getColumn(nombreList, 0, 2);
		List<Float> y = getColumn(nombreList, 1, 2);
		float B0 = calculerB0(nombreList);
		float B1 = calculerB1(nombreList);
		List<Float> xB0 = new ArrayList<Float>();
		
		for(int i = 0; i< x.size();i++) {
			xB0.add(y.get(i)-(B1*x.get(i)+B0));
		}
		return xB0;
	}
	
	public double calculerIntervale(List<Float> nombreList) {
		List<Float> x = getColumn(nombreList, 0, 2);
		List<Float> distance = new ArrayList<Float>();
		
		for(int i = 0; i< x.size(); i++) {
			distance.add(calculerDistanceCarree(x.get(i), calculerMoyenne(x)));
		}
		return  calculerEcartType(createListYRegression(nombreList))*Math.sqrt(1+(1.0/x.size())+(calculerDistanceCarree(INTERVALE_LOC,calculerMoyenne(x))/calculerSomme(distance)));
	}
	private Float calculerDistanceCarree(float xi, float moyx) {	
		return (xi-moyx)*(xi-moyx);
	}

	public double calculerIntervaleSup(List<Float> nombreList) {
		return STUDENT_90 * calculerIntervale(nombreList);
	}
	public double calculerIntervaleInf(List<Float> nombreList) {
		return STUDENT_70 * calculerIntervale(nombreList);
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
