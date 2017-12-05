package modelo.tablero.acciones;

import modelo.entidades.Jugador;
import modelo.entidades.MovimientoEncarcelado;

public class CondenaRealSinFianza extends Condena {

	public CondenaRealSinFianza(int cantidadDeTurnosTranscurridos) {
		
		super(cantidadDeTurnosTranscurridos);
	}

	@Override
	public void pagarFianzaDeJugadorEnCarcel(Jugador jugador, Carcel carcel) {
		
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		
		unJugador.cambiarTipoDeMovimiento(new MovimientoEncarcelado());
	}

	@Override
	public boolean fianzaDisponible() {
		
		return false;
	}

}
