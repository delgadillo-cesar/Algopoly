package modelo.entidades;


public class MovimientoTiradaMenosDos extends MovimientoDesplazamietoDinamico {

	@Override
	public int calcularCantidadCasillerosADesplazar(Jugador unJugador, int cantidadDeCasilleros) {
		return (cantidadDeCasilleros - 2);
	}

	
}
