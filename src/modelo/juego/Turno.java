package modelo.juego;

import java.util.LinkedList;

import modelo.entidades.Jugador;

public class Turno {

	private LinkedList<Jugador> jugadores;

	private Jugador jugadorActual;
	private Jugador jugadorAnterior;
	private static Turno elTurno;

	private Turno(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.jugadorActual = this.jugadores.getFirst();
		this.jugadorAnterior = this.jugadores.getLast();
	}

	public static Turno inicializarTurno(LinkedList<Jugador> jugadores){
		elTurno = new Turno(jugadores);
		return elTurno;
	}

	
	public static Turno getInstance(){
		if(elTurno == null)
			elTurno = new Turno(null);
		return elTurno;
	}
	
	public Jugador turnoActual(){
		return this.jugadorActual;
	}
	
	public Jugador cambiarTurno() {
		if (Dados.getInstance().salieronPares() && !this.jugadorActual.equals(this.jugadorAnterior)) { // Dados pares &&
			this.repetirTurno();
		} else {
			this.avanzarTurno();
		}
/*
		if (!Dados.getInstance().salieronPares()) {
			Carcel laCarcel = (Carcel) Tablero.getInstance().obtenerCasilla(6);
			laCarcel.revizarCondena(jugadorActual);
		}
*/
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
