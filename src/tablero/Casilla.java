package tablero;

import entidades.Jugador;
import entidades.JugadorAbstracto;
import entidades.MismoJugadorException;

public abstract class Casilla {
	
	protected String descripcion;
	
	public abstract void afectar(Jugador jugador) throws MismoJugadorException;
	
	public String descripcion(){
		return this.descripcion;
	}
}
