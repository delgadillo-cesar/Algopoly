package modelo.entidades;

import modelo.tablero.PosicionTablero;
import modelo.tablero.Tablero;

public abstract class MovimientoDesplazamietoDinamico extends TipoMovimiento {

	public static final int direccionAvance = 1;
	public static final int direccionRetroceso = -1;
	private int direccion;
	
	public MovimientoDesplazamietoDinamico(){
		this.direccion = 0;
	}
	
	@Override
	public void mover(Jugador unJugador, int cantidadDeCasilleros) {
		  int nroNuevaCasilla;
		  PosicionTablero posicionJugador = unJugador.obtenerPosicion();

		  nroNuevaCasilla = posicionJugador.getPosicion() + ((this.calcularCantidadCasillerosADesplazar(unJugador, cantidadDeCasilleros)) * this.direccion);
		  posicionJugador.setPosicion(nroNuevaCasilla);
		  Tablero.ajustarPosicionSegunBordes(posicionJugador);
		  
		  unJugador.cambiarPosicion(posicionJugador);
		  unJugador.cambiarTipoDeMovimiento(new MovimientoLibre());
		  Tablero.getInstance().elJugadorSeDesplazo(unJugador); /*Para la interaccion con la nueva casilla*/
	}

	public void setDireccion(int unaDireccion) {
		this.direccion = unaDireccion;
	}
	
	public abstract int calcularCantidadCasillerosADesplazar(Jugador unJugador, int cantidadDeCasilleros);

}
