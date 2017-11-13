package acciones;

import entidades.Jugador;

public class ImpuestoLujo extends Accion{

	@Override
	public void afectar(Jugador jugador) {
		jugador.pagar((int)(jugador.capital() * 0.10));
	}

}
