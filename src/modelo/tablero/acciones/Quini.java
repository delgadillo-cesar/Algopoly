package modelo.tablero.acciones;

import java.util.HashMap;
import modelo.entidades.Jugador;
import modelo.tablero.Casilla;

public class Quini implements Casilla {

	private HashMap<Jugador, PremioQuini> ganadores;

	public Quini() {
		ganadores = new HashMap<Jugador, PremioQuini>();
	}

	public void afectar(Jugador jugador) {

		int premio = this.premioParaJugador(jugador);
		jugador.cobrar(premio);

	}

	private int premioParaJugador(Jugador unJugador) {
		if (!ganadores.containsKey(unJugador)) this.ganadores.put(unJugador, new PremioQuini());

		return (this.ganadores.get(unJugador).cobrarPremio());
	}
}
