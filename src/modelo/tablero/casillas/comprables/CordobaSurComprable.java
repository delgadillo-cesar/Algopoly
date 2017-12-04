package modelo.tablero.casillas.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.casillas.poseibles.barrios.BarrioCordobaSur;

public class CordobaSurComprable implements Comprable {

	private int precioCompra;

	public CordobaSurComprable(){
		this.precioCompra = 18000;
	}
	
	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioCordobaSur cordSur= new BarrioCordobaSur(unJugador);
		unJugador.agregarBarrio(cordSur);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_SUR, cordSur);
	}
}
