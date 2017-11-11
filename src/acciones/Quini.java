package acciones;

import java.util.HashMap;

import entidades.Jugador;
import entidades.Nadie;

public class Quini extends Accion{

	private HashMap<Jugador, Integer> vecesGanadas;
	
	public Quini() {
		
		vecesGanadas = new HashMap<Jugador, Integer>();
		
	}
	
	@Override
	public void afectar(Jugador jugador) {
		
		int premio = premioParaJugador(jugador);
		jugador.cobrar(premio);
		
	}
	
	private int premioParaJugador(Jugador unJugador) {
		
		// nunca lo gano
		if (vecesGanadas.get(unJugador) == null) {
			vecesGanadas.put(unJugador, 1);
			return 50000;
		}
		
		else if (vecesGanadas.get(unJugador) == 1) {
			vecesGanadas.put(unJugador, 2);
			return 30000;
		}
		return 0;
	}

	@Override
	public Jugador propietario() {
		
		return new Nadie();
	}
}
