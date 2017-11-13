package acciones;

import tablero.Tablero;
import entidades.Jugador;

public class Policia extends Accion {

	@Override
	public void afectar(Jugador jugador) {
		Tablero.getInstance().desplazar(jugador, "CARCEL");
	}

}
