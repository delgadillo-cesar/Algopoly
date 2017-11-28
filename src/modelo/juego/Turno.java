package modelo.juego;

import java.util.LinkedList;

import modelo.entidades.Jugador;

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
		this.jugadores.removeFirst();
		this.jugadores.addLast(jugadorAnterior);
		this.jugadorActual = this.jugadores.getFirst();
	}

}
