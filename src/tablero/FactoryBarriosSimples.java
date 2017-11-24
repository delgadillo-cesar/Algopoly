package tablero;

import java.util.HashMap;

import barrios.BarrioNeuquen;
import barrios.BarrioSantaFe;
import barrios.BarrioTucuman;



public class FactoryBarriosSimples implements FactoryCasillas{

	public HashMap<String, Casilla> crearCasillas() {
		HashMap<String, Casilla> casillas = new HashMap<String, Casilla>();
		
		casillas.put(BarrioSantaFe.getTag(), new BarrioSantaFe());
		casillas.put(BarrioNeuquen.getTag(), new BarrioNeuquen());
		casillas.put(BarrioTucuman.getTag(), new BarrioTucuman());
		
		return casillas;
	}

}
