package modelo.tablero.comprables;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioCordobaSur;

public class CordobaSurComprable implements Comprable {

	private int precioCompra;

	public CordobaSurComprable() {
		this.precioCompra = 18000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioCordobaSur cordSur = new BarrioCordobaSur(unJugador);
		unJugador.agregarBarrio(cordSur);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_SUR, cordSur);
		precioCompra = 0;
	}
}
