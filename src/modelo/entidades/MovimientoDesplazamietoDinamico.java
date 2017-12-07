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

		  int cantidadAMover = (this.calcularCantidadCasillerosADesplazar(unJugador, cantidadDeCasilleros)) * this.direccion;
		  nroNuevaCasilla = unJugador.obtenerPosicion().getPosicion() + cantidadAMover;
		  unJugador.cambiarPosicion(Tablero.ajustarPosicionSegunBordes(new PosicionTablero(nroNuevaCasilla)));
		  unJugador.cambiarTipoDeMovimiento(new MovimientoLibre());
	}

	public void setDireccion(int unaDireccion) {
		this.direccion = unaDireccion;
	}
	
	public abstract int calcularCantidadCasillerosADesplazar(Jugador unJugador, int cantidadDeCasilleros);

}
