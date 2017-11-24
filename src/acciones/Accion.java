package acciones;

import entidades.Jugador;
import tablero.Casilla;

public abstract class Accion implements Casilla {

	protected String descripcion;

	public abstract void afectar(Jugador jugador);
	
	public String descripcion(){
		return this.descripcion;
	}
}
