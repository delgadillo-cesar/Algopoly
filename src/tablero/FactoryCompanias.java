package tablero;

import java.util.HashMap;

import poseibles.Aysa;
import poseibles.Edesur;
import poseibles.Subte;
import poseibles.Tren;



public class FactoryCompanias implements FactoryCasillas {

	public HashMap<String, Casilla> crearCasillas() {
		HashMap<String, Casilla> casillas = new HashMap<String, Casilla>();
		
		casillas.put(Aysa.getTag(), new Aysa());
		casillas.put(Edesur.getTag(), new Edesur());
		casillas.put(Subte.getTag(), new Subte());
		casillas.put(Tren.getTag(), new Tren());
		
		return casillas;
	}

}
