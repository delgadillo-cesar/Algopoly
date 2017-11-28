package comprables;

import barrios.BarrioTucuman;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class TucumanComprable implements Comprable {

	private int precioCompra;

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioTucuman tucuman= new BarrioTucuman(unJugador);
		unJugador.agregarBarrio(tucuman);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TUCUMAN, tucuman);
	}
}
