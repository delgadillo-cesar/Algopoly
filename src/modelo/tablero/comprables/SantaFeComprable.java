package modelo.tablero.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.poseibles.barrios.BarrioSantaFe;

public class SantaFeComprable implements Comprable {

	private int precioCompra;

	public SantaFeComprable(){
		this.precioCompra = 15000;
	}
	
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
