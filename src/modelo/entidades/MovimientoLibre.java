package modelo.entidades;

import modelo.tablero.PosicionTablero;
import modelo.tablero.Tablero;


public class MovimientoLibre extends TipoMovimiento {

	@Override
	public void mover(Jugador unJugador, int cantidadDeCasilleros){
		  int nroNuevaCasilla;
		  PosicionTablero posicionJugador = unJugador.obtenerPosicion();

		  nroNuevaCasilla = posicionJugador.getPosicion() + cantidadDeCasilleros;
		  
		  unJugador.cambiarPosicion(Tablero.getInstance().ajustarPosicionSegunBordes(new PosicionTablero(nroNuevaCasilla)));
//		  Tablero.getInstance().elJugadorSeDesplazo(unJugador); /*Para la interaccion con la nueva casilla*/
		}
}
