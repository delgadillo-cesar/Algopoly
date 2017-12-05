package modelo.tablero.acciones;

import modelo.entidades.Jugador;

public abstract class Condena {
	
	public int turnosTranscurridos;
	
	public Condena(int cantidadDeTurnosTranscurridos) {
		
		turnosTranscurridos = cantidadDeTurnosTranscurridos;
	}
	
	@Override
	public boolean equals(Object otraCondena) {
		
		Condena otra = (Condena) otraCondena;
		return (otra.turnosTranscurridos == this.turnosTranscurridos);
	}
	
	@Override
	public int hashCode() {
		
		final int numeroSemilla = 31;
		return numeroSemilla + turnosTranscurridos;
	}

	public abstract void afectarJugador(Jugador unJugador);

	public abstract void pagarFianzaDeJugadorEnCarcel(Jugador jugador, Carcel carcel);

	public abstract boolean fianzaDisponible();
}
