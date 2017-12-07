package modelo.juego;

import java.util.LinkedList;

import modelo.entidades.Jugador;

public class Turno {
	
	private static Turno elTurno;
	
	
	private LinkedList<Jugador> jugadores;
	
	private Jugador jugadorAnterior;

	private Turno(LinkedList<Jugador> jugadoresDelJuego) {
		jugadores = jugadoresDelJuego;
		jugadorAnterior = jugadoresDelJuego.getLast();
	}

	public static Turno inicializarTurno(LinkedList<Jugador> jugadoresDelJuego){
		elTurno = new Turno(jugadoresDelJuego);
		return elTurno;
	}

	
	public static Turno getInstance(){
		if(elTurno == null)
			elTurno = new Turno(null);
		return elTurno;
	}
	
	public Jugador turnoActual(){
		return jugadores.peek();
	}
	
	public Jugador cambiarTurno() {
		if (Dados.getInstance().salieronPares() && (jugadores.peek() != jugadorAnterior)) {
			jugadorAnterior = jugadores.peek();
			return jugadores.peek();
		}
		Jugador actual = jugadores.poll();
		jugadores.add(actual);
		return jugadores.peek();
	}	

	public void quitarJugadorActual() {
		
		jugadores.poll();
	}

}
