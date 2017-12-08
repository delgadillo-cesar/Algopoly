package modelo.tablero.acciones;

import modelo.entidades.Jugador;
import modelo.entidades.MovimientoEncarcelado;

public class CondenaRealConFianza extends Condena {

	public CondenaRealConFianza(int cantidadDeTurnosTranscurridos) {
		super(cantidadDeTurnosTranscurridos);
		
	}

	@Override
	public void pagarFianzaDeJugadorEnCarcel(Jugador jugador, Carcel carcel) {
		
		carcel.liberar(jugador);
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		
		unJugador.cambiarTipoDeMovimiento(new MovimientoEncarcelado());
	}

	@Override
	public boolean fianzaDisponible() {
		
		return true;
	}

}
