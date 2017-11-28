package modelo.tablero.casillas.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.casillas.poseibles.barrios.BarrioTucuman;

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
