package comprables;

import barrios.BarrioSaltaSur;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class SaltaSurComprable implements Comprable {

	private int precioCompra;

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioSaltaSur saltaSur= new BarrioSaltaSur(unJugador);
		unJugador.agregarBarrio(saltaSur);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_SUR, saltaSur);
	}
}
