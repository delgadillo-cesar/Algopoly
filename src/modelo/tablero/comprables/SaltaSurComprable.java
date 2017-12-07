package modelo.tablero.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.poseibles.BarrioYaHabiaSidoCompradoException;
import modelo.tablero.poseibles.barrios.BarrioSaltaSur;

public class SaltaSurComprable implements Comprable {

	private int precioCompra;

	public SaltaSurComprable(){
		this.precioCompra = 23000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		if (precioCompra > 0) {
			unJugador.pagarA(Banco.getInstance(), precioCompra);
			BarrioSaltaSur saltaSur= new BarrioSaltaSur(unJugador);
			unJugador.agregarBarrio(saltaSur);
			Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_SUR, saltaSur);
			precioCompra = 0;
		} else {
			throw new BarrioYaHabiaSidoCompradoException();
		}
	}
}
