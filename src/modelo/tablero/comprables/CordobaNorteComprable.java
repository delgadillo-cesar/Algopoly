package modelo.tablero.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.poseibles.BarrioYaHabiaSidoCompradoException;
import modelo.tablero.poseibles.barrios.Barrio;
import modelo.tablero.poseibles.barrios.BarrioCordobaNorte;

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
		if (precioCompra != 0) {
			unJugador.pagarA(Banco.getInstance(), precioCompra);
			BarrioCordobaNorte cordNor= new BarrioCordobaNorte(unJugador);
			unJugador.agregarBarrio(cordNor);
			Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_NORTE, cordNor);
			precioCompra = 0;
		} else {
			throw new BarrioYaHabiaSidoCompradoException();
		}
	}
}
