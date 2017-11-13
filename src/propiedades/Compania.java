package propiedades;

import entidades.Jugador;

public class Compania extends Propiedad {

	@Override
	public void afectar(Jugador jugador) {
		jugador.comprar(this);
		propietario = jugador;
	}

}
