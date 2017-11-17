package propiedades;

import entidades.Jugador;
import entidades.JugadorAbstracto;
import entidades.JugadorNadieException;
import entidades.MismoJugadorException;

public abstract class Compania extends Propiedad {

	@Override
	public void afectar(Jugador jugador) {
		propietario.cobrar(jugador.pagar(this.cobrar()));
	}
	
	protected abstract int cobrar();

}
