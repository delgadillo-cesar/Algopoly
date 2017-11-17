package entidades;

import juego.Dados;
import tablero.PosicionTablero;
import tablero.Tablero;

public class MovimientoLibre extends TipoMovimiento {

	private int cantCasillas;
	
	public MovimientoLibre(){
		cantCasillas = Tablero.getNumeroCasillas();
	}

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
