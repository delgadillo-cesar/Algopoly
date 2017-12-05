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

		  int cantidadAMover = (this.calcularCantidadCasillerosADesplazar(unJugador, cantidadDeCasilleros)) * this.direccion;
		  nroNuevaCasilla = posicionJugador.getPosicion() + cantidadAMover;
		  posicionJugador.setPosicion(nroNuevaCasilla);
		  Tablero.ajustarPosicionSegunBordes(posicionJugador);
		  
		  unJugador.cambiarPosicion(posicionJugador);
		  unJugador.cambiarTipoDeMovimiento(new MovimientoLibre());
		  
		  if (cantidadAMover != 0) Tablero.getInstance().elJugadorSeDesplazo(unJugador); /*Para la interaccion con la nueva casilla*/
	}

	public void setDireccion(int unaDireccion) {
		this.direccion = unaDireccion;
	}
	
	public abstract int calcularCantidadCasillerosADesplazar(Jugador unJugador, int cantidadDeCasilleros);

}
