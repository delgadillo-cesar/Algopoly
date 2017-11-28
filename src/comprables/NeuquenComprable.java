package comprables;

import barrios.BarrioNeuquen;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class NeuquenComprable implements Comprable {

	private int precioCompra;

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioNeuquen neuquen= new BarrioNeuquen(unJugador);
		unJugador.agregarBarrio(neuquen);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_NEUQUEN, neuquen);
	}
}
