package acciones;

import tablero.Tablero;
import entidades.Jugador;

public class Policia extends Accion {

	private static String tag = "POLICIA";
	
	public Policia(){
		this.descripcion = "POLICIA";
	}
	
	@Override
	public void afectar(Jugador jugador) {
		Tablero.getInstance().desplazar(jugador, "CARCEL");
	}

	public static String getTag(){
		return tag;
	}
}
