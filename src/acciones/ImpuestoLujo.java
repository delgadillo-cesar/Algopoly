package acciones;

import entidades.Banco;
import entidades.Jugador;
import tablero.Casilla;

public class ImpuestoLujo implements Casilla {

	private final Double porcentajeImpuesto = Double.valueOf(0.10);

	public ImpuestoLujo(){
	}
	
	public void afectar(Jugador jugador) {
		jugador.pagarA(Banco.getInstance(), (int) (jugador.capital() * porcentajeImpuesto));
	}
	
}
