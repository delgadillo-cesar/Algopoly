package tablero;

import java.util.HashMap;

import entidades.Jugador;
import entidades.PropietarioException;

public class Tablero {

	private static Tablero elTablero;
	private final Integer CANTIDAD_CASILLAS = 20;
	private HashMap<String, Casilla> casillas;
	private HashMap<Integer, Casilla> numeroCasilla;
	
	private Tablero(){
		
	}
		
	public static Tablero getInstance() {
		if (elTablero == null){
			elTablero = new Tablero();
		}
		return elTablero;
	}

	public void desplazar(Jugador jugador, int desplazarCasilleros) {
		Casilla nuevaCasilla;
		Integer nroCasillaJugador = 0; /*Falta obtener casilla jugador*/
		Integer nroCasillaNueva = nroCasillaJugador + desplazarCasilleros;
		
		if (nroCasillaNueva > this.CANTIDAD_CASILLAS) nroCasillaNueva -= CANTIDAD_CASILLAS;
		if (nroCasillaNueva < 1) nroCasillaNueva += CANTIDAD_CASILLAS;
		
		nuevaCasilla = numeroCasilla.get(nroCasillaNueva);
		
		/*Desplazar Jugador*/
		
		
		try {
			nuevaCasilla.afectar(jugador);
		} catch (PropietarioException e) {
		}
	}
	
	public void desplazar(Jugador jugador, String unaDescrripcionCasilla) {
		Casilla nuevaCasilla = casillas.get(unaDescrripcionCasilla);
		
		/*Desplazar Jugador*/
		
		
		try {
			nuevaCasilla.afectar(jugador);
		} catch (PropietarioException e) {
		}
	}
	

}
