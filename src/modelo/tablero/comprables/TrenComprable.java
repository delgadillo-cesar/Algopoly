package modelo.tablero.comprables;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.compania.Tren;

public class TrenComprable implements Comprable {

	private int precioCompra;

	public TrenComprable() {
		this.precioCompra = 38000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		Tren tren = new Tren(unJugador);
		unJugador.agregarCompania(tren);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TREN, tren);
		precioCompra = 0;
	}
}
