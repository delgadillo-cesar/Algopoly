package modelo.tablero.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.poseibles.BarrioYaHabiaSidoCompradoException;
import modelo.tablero.poseibles.barrios.BarrioBuenosAiresSur;

public class BuenosAiresSurComprable implements Comprable {

	private int precioCompra;

	public BuenosAiresSurComprable(){
		this.precioCompra = 20000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		if (precioCompra > 0) {
			unJugador.pagarA(Banco.getInstance(), precioCompra);
			BarrioBuenosAiresSur bueSur= new BarrioBuenosAiresSur(unJugador);
			unJugador.agregarBarrio(bueSur);
			Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_SUR, bueSur);
			precioCompra = 0;
		} else {
			throw new BarrioYaHabiaSidoCompradoException();
		}
	}
}
