package modelo.tablero.casillas.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.casillas.poseibles.barrios.BarrioCordobaNorte;

public class CordobaNorteComprable implements Comprable {

	private int precioCompra;

	public CordobaNorteComprable(){
		this.precioCompra = 20000;
	}
	
	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioCordobaNorte cordNor= new BarrioCordobaNorte(unJugador);
		unJugador.agregarBarrio(cordNor);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_NORTE, cordNor);
	}
}
