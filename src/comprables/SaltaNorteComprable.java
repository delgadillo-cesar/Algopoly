package comprables;

import barrios.BarrioSaltaNorte;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class SaltaNorteComprable implements Comprable {

	private int precioCompra;

	public void afectar(Jugador jugador) {
	}

	public int precioDeCompra() {
		return this.precioCompra;
	}

	public void comprar(Jugador unJugador) {
		unJugador.pagarA(Banco.getInstance(), precioCompra);
		BarrioSaltaNorte saltaNor= new BarrioSaltaNorte(unJugador);
		unJugador.agregarBarrio(saltaNor);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_NORTE, saltaNor);
	}
}
