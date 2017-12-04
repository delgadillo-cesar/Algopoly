package modelo.tablero.casillas.comprables;

import modelo.entidades.*;
import modelo.tablero.*;
import modelo.tablero.casillas.poseibles.barrios.BarrioNeuquen;

public class NeuquenComprable implements Comprable {

	private int precioCompra;

	public NeuquenComprable(){
		this.precioCompra = 17000;
	}
	
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
