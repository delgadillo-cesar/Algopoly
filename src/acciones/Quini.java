package acciones;

import java.util.HashMap;

import entidades.Jugador;

public class Quini extends Accion {

	private static String tag = "QUINI";
	
	
	private HashMap<Jugador, PremioQuini> ganadores;

	public Quini() {
		this.descripcion = "QUINI 6";

		ganadores = new HashMap<Jugador, PremioQuini>();
	}

	@Override
	public void afectar(Jugador jugador) {

		int premio = this.premioParaJugador(jugador);
		jugador.cobrar(premio);

	}

	private int premioParaJugador(Jugador unJugador) {
		if (!ganadores.containsKey(unJugador)) this.ganadores.put(unJugador, new PremioQuini());

		return (this.ganadores.get(unJugador).cobrarPremio());
	}

	
	public static String getTag(){
		return tag;
	}

}
