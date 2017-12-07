package modelo.tablero.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.poseibles.compania.Aysa;


public class AysaComprable implements Comprable{

	private int precioCompra;

	public AysaComprable(){
		this.precioCompra = 3000;
	}

	
	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		Aysa aysa = new Aysa(unJugador);
		unJugador.agregarCompania(aysa);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_AYSA, aysa);
	}
}
