package tablero;

import entidades.Jugador;
import entidades.MismoJugadorException;

public abstract class Casilla {
	
	public abstract void afectar(Jugador jugador) throws MismoJugadorException;
}
