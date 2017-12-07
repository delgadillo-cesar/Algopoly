package modelo.tablero.comprables;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioBuenosAiresNorte;

public class BuenosAiresNorteComprable implements Comprable {

	private int precioCompra;

	public BuenosAiresNorteComprable() {
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
		precioCompra = 0;
	}
}
