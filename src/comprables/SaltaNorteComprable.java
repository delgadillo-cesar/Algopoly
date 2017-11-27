package comprables;

import barrios.BarrioSaltaNorte;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class SaltaNorteComprable implements Comprable {

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
		BarrioSaltaNorte saltaNor= new BarrioSaltaNorte(unJugador);
		unJugador.agregarBarrio(saltaNor);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_NORTE, saltaNor);
	}
}
