package modelo.entidades;

public class MovimientoDesplazamietoDinamico2  extends MovimientoDesplazamietoDinamico {

	@Override
	public int calcularCantidadCasillerosADesplazar(Jugador unJugador, int cantidadDeCasilleros) {
		return ((unJugador.capital()) % cantidadDeCasilleros);
	}
}
