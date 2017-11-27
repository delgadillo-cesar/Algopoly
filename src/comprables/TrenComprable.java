package comprables;

import poseibles.Tren;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class TrenComprable implements Comprable {

	private int precioCompra;

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
	}
}
