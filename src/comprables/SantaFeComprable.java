package comprables;

import barrios.BarrioSantaFe;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class SantaFeComprable implements Comprable {

	private int precioCompra;

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioSantaFe santaFe= new BarrioSantaFe(unJugador);
		unJugador.agregarBarrio(santaFe);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SANTA_FE, santaFe);
	}
}
