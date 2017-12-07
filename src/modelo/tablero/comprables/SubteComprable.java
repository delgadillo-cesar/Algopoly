package modelo.tablero.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.poseibles.BarrioYaHabiaSidoCompradoException;
import modelo.tablero.poseibles.Subte;

public class SubteComprable implements Comprable {

	private int precioCompra;

	public SubteComprable(){
		this.precioCompra = 40000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		if (precioCompra > 0) {
			unJugador.pagarA(Banco.getInstance(), precioCompra);
			Subte subte = new Subte(unJugador);
			unJugador.agregarCompania(subte);
			Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SUBTE, subte);
			precioCompra = 0;
		} else {
			throw new BarrioYaHabiaSidoCompradoException();
		}
	}
}
