package entidades;

public class MovimientoDesplazamietoDinamico3 extends MovimientoDesplazamietoDinamico {

	@Override
	public int calcularCantidadCasillerosADesplazar(Jugador unJugador, int cantidadDeCasilleros) {
		return (cantidadDeCasilleros - unJugador.cantidadPropiedades());
	}
}
