package modelo.tablero.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.poseibles.BarrioYaHabiaSidoCompradoException;
import modelo.tablero.poseibles.Tren;

public class TrenComprable implements Comprable {

	private int precioCompra;

	public TrenComprable(){
		this.precioCompra = 38000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		if (precioCompra > 0) {
			unJugador.pagarA(Banco.getInstance(), precioCompra);
			Tren tren = new Tren(unJugador);
			unJugador.agregarCompania(tren);
			Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TREN, tren);
			precioCompra = 0;
		} else {
			throw new BarrioYaHabiaSidoCompradoException();
		}
	}
}
