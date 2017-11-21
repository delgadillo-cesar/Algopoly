package tablero;

import entidades.Jugador;
import entidades.MismoJugadorException;

public interface Casilla {
	
	public void afectar(Jugador jugador);
	public String descripcion();
}
