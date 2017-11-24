package entidades;


public class MovimientoDesplazamietoDinamico1 extends MovimientoDesplazamietoDinamico {

	@Override
	public int calcularCantidadCasillerosADesplazar(Jugador unJugador, int cantidadDeCasilleros) {
		return (cantidadDeCasilleros - 2);
	}

	
}
