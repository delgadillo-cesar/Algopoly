package acciones;

import entidades.Jugador;

public class Salida extends Accion {

	private static String tag = "SALIDA";
	
	public Salida(){
		this.descripcion = "SALIDA";
	}
	
	@Override
	public void afectar(Jugador jugador) {
	}

	public static String getTag(){
		return tag;
	}

}
