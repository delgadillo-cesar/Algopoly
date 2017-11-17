package propiedades;

import entidades.Jugador;

public abstract class Compania extends Propiedad {

	@Override
	public void afectar(Jugador jugador) {
		propietario.cobrar(jugador.pagar(this.cobrar()));
	}
	
	protected abstract int cobrar();

}
