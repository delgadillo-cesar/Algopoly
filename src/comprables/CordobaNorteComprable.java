package comprables;

import barrios.BarrioCordobaNorte;
import entidades.Banco;
import entidades.Jugador;
import tablero.Comprable;
import tablero.Tablero;

public class CordobaNorteComprable implements Comprable {

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
		BarrioCordobaNorte cordNor= new BarrioCordobaNorte(unJugador);
		unJugador.agregarBarrio(cordNor);
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_NORTE, cordNor);
	}
}
