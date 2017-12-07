package modelo.tablero.comprables;

import modelo.entidades.Banco;
import modelo.entidades.Jugador;
import modelo.tablero.Comprable;
import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioNeuquen;

public class NeuquenComprable implements Comprable {

	private int precioCompra;

	public NeuquenComprable() {
		this.precioCompra = 17000;
	}

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioNeuquen neuquen = new BarrioNeuquen(unJugador);
		unJugador.agregarBarrio(neuquen);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_NEUQUEN, neuquen);
		precioCompra = 0;
	}
}
