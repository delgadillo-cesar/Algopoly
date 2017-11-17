package entidades;

import tablero.PosicionTablero;
import tablero.Tablero;

public class MovimientoLibre extends TipoMovimiento {

	@Override
	public void mover(Jugador unJugador, int cantidadDeCasilleros){
		  int nroNuevaCasilla;
		  PosicionTablero posicionJugador = unJugador.obtenerPosicion();

		  nroNuevaCasilla = posicionJugador.getPosicion() + cantidadDeCasilleros;
		  posicionJugador.setPosicion(nroNuevaCasilla);
		  Tablero.ajustarPosicionSegunBordes(posicionJugador);
		  
		  unJugador.cambiarPosicion(posicionJugador);
		  Tablero.getInstance().elJugadorSeDesplazo(unJugador); /*Para la interaccion con la nueva casilla*/
		}
}
