package modelo.tablero.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.poseibles.Edesur;

public class EdesurComprable implements Comprable {

	private int precioCompra;

	public EdesurComprable(){
		this.precioCompra = 35000;
	}
	
	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		Edesur edesur = new Edesur(unJugador);
		unJugador.agregarCompania(edesur);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_EDESUR, edesur);
	}
}
