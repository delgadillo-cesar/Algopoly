package acciones;

import tablero.Casilla;
import tablero.Tablero;
import entidades.Jugador;

public class Policia implements Casilla {
	
	public Policia(){
	}
	
	public void afectar(Jugador jugador) {
		Tablero.getInstance().desplazar(jugador, Tablero.CASILLA_CARCEL);
	}
}
