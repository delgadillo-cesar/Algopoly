package propiedades;

import entidades.Jugador;
import entidades.Nadie;
import tablero.Casilla;

public abstract class Propiedad extends Casilla {
	
	protected Jugador propietario;
	
	public Propiedad() {
		
		propietario = new Nadie();
	}
	
	public Jugador propietario() {
		
		return propietario;
		
	}
			
}
