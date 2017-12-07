package modelo.entidades;

import modelo.tablero.Tablero;
import modelo.tablero.acciones.Carcel;

public class MovimientoEncarcelado extends TipoMovimiento {

	@Override
	public void mover(Jugador unJugador, int cantidadDeCasilleros) {
		Carcel laCarcel = (Carcel) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CARCEL);
		laCarcel.revisarCondena(unJugador);
	}

}
