package comprables;

import barrios.BarrioTucuman;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class TucumanComprable implements Comprable {

	private int precioCompra;

	@Override
	public void afectar(Jugador jugador) {
	}

	@Override
	public int precioDeCompra() {
		return this.precioCompra;
	}

	@Override
	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioTucuman tucuman= new BarrioTucuman(unJugador);
		unJugador.agregarBarrio(tucuman);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TUCUMAN, tucuman);
	}
}
