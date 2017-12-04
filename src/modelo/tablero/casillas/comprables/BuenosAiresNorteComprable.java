package modelo.tablero.casillas.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.casillas.poseibles.barrios.BarrioBuenosAiresNorte;


public class BuenosAiresNorteComprable implements Comprable {

	private int precioCompra;

	public BuenosAiresNorteComprable(){
		this.precioCompra = 25000;
	}
	
	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioBuenosAiresNorte bueNor= new BarrioBuenosAiresNorte(unJugador);
		unJugador.agregarBarrio(bueNor);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_NORTE, bueNor);
	}
}
