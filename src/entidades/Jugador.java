package entidades;

import propiedades.Propiedad;

public abstract class Jugador {

	public abstract void comprar(Propiedad unaPropiedad);

	public abstract int cobrar(int unMonto);

	public abstract void cobrar(int unMonto, Jugador unJugador) throws JugadorNadieException, PropietarioException;

	public abstract void pagar(int unMonto);

	public abstract int capital();

	public abstract int cantidadPropiedades ();

	public abstract boolean tienePropiedad(String unaDescipcionDePropiedad);

}
