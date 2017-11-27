package comprables;

import barrios.BarrioCordobaSur;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class CordobaSurComprable implements Comprable {

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
		BarrioCordobaSur cordSur= new BarrioCordobaSur(unJugador);
		unJugador.agregarBarrio(cordSur);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_SUR, cordSur);
	}
}
