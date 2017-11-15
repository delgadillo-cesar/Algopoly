package juego;

import java.util.LinkedList;

import entidades.Jugador;

public class Turno {

	private LinkedList<Jugador> jugadores;

	private Jugador jugadorActual;
	private Jugador jugadorAnterior;

	public Turno(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.jugadorActual = this.jugadores.getFirst();
		this.jugadorAnterior = this.jugadores.getLast();
	}

	public Jugador cambiarTurno() {
		if (Dados.getInstance().salieronPares() && !this.jugadorActual.equals(this.jugadorAnterior)) { // Dados pares &&
			this.repetirTurno();
		} else {
			this.avanzarTurno();
		}
		return this.jugadorActual;
	}

	private void repetirTurno() {
		this.jugadorAnterior = this.jugadorActual;
	}

	private void avanzarTurno() {
		this.repetirTurno();
		if (!this.jugadorActual.equals(this.jugadores.getLast())) {
			this.jugadorActual = this.jugadores.get(this.jugadores.indexOf(jugadorActual) + 1);
		} else {
			this.jugadorActual = this.jugadores.getFirst();
		}
	}

}
