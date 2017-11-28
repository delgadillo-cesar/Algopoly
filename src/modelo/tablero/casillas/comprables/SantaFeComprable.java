package modelo.tablero.casillas.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.casillas.poseibles.barrios.BarrioSantaFe;

public class SantaFeComprable implements Comprable {

	private int precioCompra;

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioSantaFe santaFe= new BarrioSantaFe(unJugador);
		unJugador.agregarBarrio(santaFe);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SANTA_FE, santaFe);
	}
}
