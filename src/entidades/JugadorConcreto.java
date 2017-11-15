package entidades;

import java.util.HashMap;
import propiedades.Propiedad;

public class JugadorConcreto extends Jugador{

	private String nombre;
	private int capital;
	private HashMap<String, Propiedad> propiedades;
	
	
	public JugadorConcreto(String unNombre) {
		nombre = unNombre;
		capital = 100000;
		propiedades = new HashMap<String, Propiedad>();
	}

	
	public int capital() {
		return capital;
	}

	
	public int cobrar(int unMonto) {
		capital += unMonto;
		
		return unMonto;
	}

	
	public void comprar(Propiedad unaPropiedad) {
		propiedades.put(unaPropiedad.nombre(), unaPropiedad);
	}
	
	
	public int cantidadPropiedades ()	{
		return this.propiedades.size();
	}

	
	@Override
	public int pagar(int unMonto) {
		capital -= unMonto;
		
		return unMonto;
	}

	
	@Override
	public void cobrar(int unMonto, Jugador unJugador) {
		if (unJugador == this) throw new MismoJugadorException();
		
		capital += unJugador.pagar(unMonto);
	}


	@Override
	public boolean tienePropiedad(String unaDescipcionDePropiedad) {
		return (propiedades.get(unaDescipcionDePropiedad) != null);
	}

}
