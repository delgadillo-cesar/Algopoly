package comprables;

import poseibles.Edesur;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class EdesurComprable implements Comprable {

	private int precioCompra;

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		Edesur edesur = new Edesur(unJugador);
		unJugador.agregarCompania(edesur);
		Tablero.getInstance().cambiarCasillaPor(this, edesur);
	}
}
