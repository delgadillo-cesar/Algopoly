package tablero;

import java.util.HashMap;

import comprables.Aysa;
import comprables.Edesur;
import comprables.Subte;
import comprables.Trenes;


public class FactoryCompanias implements FactoryCasillas {

	public HashMap<String, Casilla> crearCasillas() {
		HashMap<String, Casilla> casillas = new HashMap<String, Casilla>();
		
		casillas.put(Aysa.getTag(), new Aysa());
		casillas.put(Edesur.getTag(), new Edesur());
		casillas.put(Subte.getTag(), new Subte());
		casillas.put(Trenes.getTag(), new Trenes());
		
		return casillas;
	}

}
