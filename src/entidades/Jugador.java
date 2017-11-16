package entidades;

import propiedades.Propiedad;

public abstract class Jugador {

	public abstract void agregar(Propiedad unaPropiedad);

	public abstract int cobrar(int unMonto);

	public abstract void cobrar(int unMonto, Jugador unJugador) throws JugadorNadieException, MismoJugadorException;

	public abstract int pagar(int unMonto);

	public abstract int capital();

	public abstract int cantidadPropiedades ();

	public abstract boolean tienePropiedad(String unaDescipcionDePropiedad);

}
