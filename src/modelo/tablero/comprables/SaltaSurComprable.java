package modelo.tablero.comprables;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioSaltaSur;

public class SaltaSurComprable implements Comprable {

	private int precioCompra;

	public SaltaSurComprable() {
		this.precioCompra = 23000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioSaltaSur saltaSur = new BarrioSaltaSur(unJugador);
		unJugador.agregarBarrio(saltaSur);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_SUR, saltaSur);
		precioCompra = 0;
	}
}
