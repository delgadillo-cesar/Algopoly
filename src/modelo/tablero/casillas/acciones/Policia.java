package modelo.tablero.casillas.acciones;

import modelo.entidades.Jugador;
import modelo.tablero.*;


public class Policia implements Casilla {
	
	public Policia(){
	}
	
	public void afectar(Jugador jugador) {
		Tablero.getInstance().desplazar(jugador, Tablero.CASILLA_CARCEL);
	}
}
