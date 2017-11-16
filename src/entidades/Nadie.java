package entidades;

import propiedades.Propiedad;

public class Nadie extends Jugador{


	@Override
	public int cobrar(int unMonto) {
		throw new JugadorNadieException();
	}

	@Override
	public int capital() {
		throw new JugadorNadieException();
	}

	@Override
	public int cantidadPropiedades() {
		throw new JugadorNadieException();
	}

	@Override
	public void agregar(Propiedad unaPropiedad) {
		throw new JugadorNadieException();
	}

	@Override
	public int pagar(int unMonto) {
		throw new JugadorNadieException();
	}

	@Override
	public void cobrar(int unMonto, Jugador unJugador) throws JugadorNadieException {
		throw new JugadorNadieException();
	}

	@Override
	public boolean tienePropiedad(String unaDescipcionDePropiedad) {
		throw new JugadorNadieException();
	}

}
