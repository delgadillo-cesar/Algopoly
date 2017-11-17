package juego;

import java.util.LinkedList;

import entidades.JugadorAbstracto;

public class Turno {

	private LinkedList<JugadorAbstracto> jugadores;

	private JugadorAbstracto jugadorActual;
	private JugadorAbstracto jugadorAnterior;

	public Turno(LinkedList<JugadorAbstracto> jugadores) {
		this.jugadores = jugadores;
		this.jugadorActual = this.jugadores.getFirst();
		this.jugadorAnterior = this.jugadores.getLast();
	}

	public JugadorAbstracto cambiarTurno() {
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
