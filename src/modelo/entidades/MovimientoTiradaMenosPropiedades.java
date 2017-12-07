package modelo.entidades;

public class MovimientoTiradaMenosPropiedades extends MovimientoDesplazamietoDinamico {

	@Override
	public int calcularCantidadCasillerosADesplazar(Jugador unJugador, int cantidadDeCasilleros) {
		return (cantidadDeCasilleros - unJugador.cantidadPropiedades());
	}
}
