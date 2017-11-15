package acciones;

import entidades.Jugador;

public class ImpuestoLujo extends Accion {

	private final Double porcentajeImpuesto = Double.valueOf(0.10);

	@Override
	public void afectar(Jugador jugador) {
		jugador.pagar((int) (jugador.capital() * porcentajeImpuesto));
	}

}
