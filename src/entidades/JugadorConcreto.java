package entidades;

import java.util.HashSet;

import propiedades.Propiedad;
import propiedades.Terreno;

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

	public void cobrar(int unMonto) {
		
		capital += unMonto;
		
	}

	public void comprar(Terreno unTerreno) {

		propiedades.add(unTerreno);
		
	}
	
	public int cantidadPropiedades ()	{
	
		return this.propiedades.size();
	}

}
