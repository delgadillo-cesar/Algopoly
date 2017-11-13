package propiedades;

import entidades.Jugador;
import entidades.JugadorNadieException;
import entidades.PropietarioException;

public abstract class Compania extends Propiedad {

	@Override
	public void afectar(Jugador jugador) {
		try {
			propietario.cobrar(this.cobrar(), jugador);
		} catch (JugadorNadieException e) {
			this.comprar(jugador);
		} catch (PropietarioException e) {
		}
	}
	
	protected abstract int cobrar();

}
