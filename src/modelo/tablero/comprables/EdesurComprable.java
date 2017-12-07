package modelo.tablero.comprables;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.Edesur;

public class EdesurComprable implements Comprable {

	private int precioCompra;

	public EdesurComprable() {
		this.precioCompra = 35000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		Edesur edesur = new Edesur(unJugador);
		unJugador.agregarCompania(edesur);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_EDESUR, edesur);
		precioCompra = 0;
	}
}
