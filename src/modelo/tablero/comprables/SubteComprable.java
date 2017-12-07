package modelo.tablero.comprables;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.compania.Subte;

public class SubteComprable implements Comprable {

	private int precioCompra;

	public SubteComprable() {
		this.precioCompra = 40000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		Subte subte = new Subte(unJugador);
		unJugador.agregarCompania(subte);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SUBTE, subte);
		precioCompra = 0;
	}
}
