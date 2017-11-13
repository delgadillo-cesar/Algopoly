package entidades;

import propiedades.Propiedad;

public class Nadie extends Jugador{


	@Override
	public int cobrar(int unMonto) {
		return 0;
	}

	@Override
	public int capital() {
		return 0;
	}

	@Override
	public int cantidadPropiedades() {
		return 0;
	}

	@Override
	public void comprar(Propiedad unaPropiedad) {
	}

	@Override
	public void pagar(int unMonto) {
	}

	@Override
	public void cobrar(int unMonto, Jugador unJugador) throws JugadorNadieException {
		throw new JugadorNadieException();
	}

}
