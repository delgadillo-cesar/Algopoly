package acciones;

import entidades.Jugador;
import entidades.JugadorAbstracto;
import entidades.MismoJugadorException;

public class Salida extends Accion {

	public Salida(){
		this.descripcion = "SALIDA";
	}
	
	@Override
	public void afectar(Jugador jugador) {
	}

}
