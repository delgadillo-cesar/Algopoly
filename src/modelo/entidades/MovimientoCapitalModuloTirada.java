package modelo.entidades;

public class MovimientoCapitalModuloTirada  extends MovimientoDesplazamietoDinamico {

	@Override
	public int calcularCantidadCasillerosADesplazar(Jugador unJugador, int cantidadDeCasilleros) {
		return ((unJugador.capital()) % cantidadDeCasilleros);
	}
}
