package tablero;

import entidades.Jugador;
import entidades.PropietarioException;

public abstract class Casilla {
	
	public abstract void afectar(Jugador jugador) throws PropietarioException;
}
