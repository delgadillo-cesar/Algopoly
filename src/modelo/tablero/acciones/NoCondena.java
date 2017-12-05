package modelo.tablero.acciones;

import modelo.entidades.Jugador;
import modelo.entidades.MovimientoLibre;

public class NoCondena extends Condena {

	public NoCondena(int cantidadDeTurnosTranscurridos) {
		
		super(cantidadDeTurnosTranscurridos);		
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		
		unJugador.cambiarTipoDeMovimiento(new MovimientoLibre());		
	}

	@Override
	public void pagarFianzaDeJugadorEnCarcel(Jugador jugador, Carcel carcel) {
		
	}

	@Override
	public boolean fianzaDisponible() {
		
		return false;
	}

}
