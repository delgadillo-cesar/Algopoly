package acciones;

import java.util.HashMap;

import entidades.Jugador;

public class Quini extends Accion {

	private HashMap<Jugador, Integer> vecesGanadas;

	public Quini() {
		this.descripcion = "QUINI 6";

		vecesGanadas = new HashMap<Jugador, Integer>();

	}

	@Override
	public void afectar(Jugador jugador) {

		int premio = premioParaJugador(jugador);
		jugador.cobrar(premio);

	}

	private int premioParaJugador(Jugador unJugador) {
		
		int premio = 50000;
		
		if (vecesGanadas.containsKey(unJugador)){
			int cantidadDeVecesGanadas = vecesGanadas.get(unJugador);
			if (cantidadDeVecesGanadas == 1) premio = 30000; else premio = 0;			
			
			vecesGanadas.put(unJugador, cantidadDeVecesGanadas + 1);
		}else{
			vecesGanadas.put(unJugador, 1);			
		}
		return premio;
	}

}
