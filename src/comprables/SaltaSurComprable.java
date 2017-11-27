package comprables;

import barrios.BarrioSaltaSur;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class SaltaSurComprable implements Comprable {

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
		BarrioSaltaSur saltaSur= new BarrioSaltaSur(unJugador);
		unJugador.agregarBarrio(saltaSur);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_SUR, saltaSur);
	}
}
