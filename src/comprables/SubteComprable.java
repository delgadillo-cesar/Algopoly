package comprables;

import poseibles.Subte;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class SubteComprable implements Comprable {

	private int precioCompra;

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		Subte subte = new Subte(unJugador);
		unJugador.agregarCompania(subte);
		Tablero.getInstance().cambiarCasillaPor(this, subte);
	}
}
