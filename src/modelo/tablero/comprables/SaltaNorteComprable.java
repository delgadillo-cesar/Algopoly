package modelo.tablero.comprables;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioSaltaNorte;

public class SaltaNorteComprable implements Comprable {

	private int precioCompra;

	public SaltaNorteComprable() {
		this.precioCompra = 23000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioSaltaNorte saltaNor = new BarrioSaltaNorte(unJugador);
		unJugador.agregarBarrio(saltaNor);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_NORTE, saltaNor);
		precioCompra = 0;
	}
}
