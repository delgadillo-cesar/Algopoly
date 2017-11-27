package comprables;

import barrios.BarrioNeuquen;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class NeuquenComprable implements Comprable {

	private int precioCompra;

	@Override
	public void afectar(Jugador jugador) {
	}

	@Override
	public int precioDeCompra() {
		return this.precioCompra;
	}

	@Override
	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioNeuquen neuquen= new BarrioNeuquen(unJugador);
		unJugador.agregarBarrio(neuquen);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_NEUQUEN, neuquen);
	}
}
