package entidades;

import java.util.HashSet;
import propiedades.Propiedad;

public class JugadorConcreto extends Jugador{

	private String nombre;
	private int capital;
	private HashSet<Propiedad> propiedades;
	
	
	public JugadorConcreto(String unNombre) {
		nombre = unNombre;
		capital = 100000;
		propiedades = new HashSet<Propiedad>();
	}

	
	public int capital() {
		return capital;
	}

	
	public int cobrar(int unMonto) {
		capital += unMonto;
		
		return unMonto;
	}

	
	public void comprar(Propiedad unaPropiedad) {
		propiedades.add(unaPropiedad);
	}
	
	
	public int cantidadPropiedades ()	{
		return this.propiedades.size();
	}

	
	@Override
	public void pagar(int unMonto) {
		capital -= unMonto;
	}

	
	@Override
	public void cobrar(int unMonto, Jugador unJugador) throws PropietarioException {
		if (unJugador == this) throw new PropietarioException();
		
		capital += unJugador.cobrar(unMonto);
	}

}
