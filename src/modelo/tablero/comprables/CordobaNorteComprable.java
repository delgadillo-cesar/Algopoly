package modelo.tablero.comprables;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioCordobaNorte;

public class CordobaNorteComprable implements Comprable {

	private int precioCompra;

	public CordobaNorteComprable() {
		this.precioCompra = 20000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioCordobaNorte cordNor = new BarrioCordobaNorte(unJugador);
		unJugador.agregarBarrio(cordNor);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_NORTE, cordNor);
		precioCompra = 0;
	}
}
