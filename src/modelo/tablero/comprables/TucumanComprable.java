package modelo.tablero.comprables;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.BarrioYaHabiaSidoCompradoException;
import modelo.tablero.poseibles.barrios.BarrioTucuman;

public class TucumanComprable implements Comprable {

	private int precioCompra;

	public TucumanComprable(){
		this.precioCompra = 25000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		if (precioCompra > 0) {
			unJugador.pagarA(Banco.getInstance(), precioCompra);
			BarrioTucuman tucuman= new BarrioTucuman(unJugador);
			unJugador.agregarBarrio(tucuman);
			Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TUCUMAN, tucuman);
			precioCompra = 0;
		} else {
			throw new BarrioYaHabiaSidoCompradoException();
		}
	}
}
