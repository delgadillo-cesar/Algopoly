package tablero;

import java.util.HashMap;

import acciones.*;
import juego.Dados;

public class FactoryAcciones implements FactoryCasillas{

	public HashMap<String, Casilla> crearCasillas() {
		HashMap<String, Casilla> casillas = new HashMap<String, Casilla>();
		
		casillas.put(AvanceDinamico.getTag(), new AvanceDinamico());
		casillas.put(Carcel.getTag(), new Carcel());
		casillas.put(ImpuestoLujo.getTag(), new ImpuestoLujo());
		casillas.put(Policia.getTag(), new Policia());
		casillas.put(Quini.getTag(), new Quini());
		casillas.put(RetrocesoDinamico.getTag(), new RetrocesoDinamico());
		casillas.put(Salida.getTag(), new Salida());

		return casillas;
	}

}
