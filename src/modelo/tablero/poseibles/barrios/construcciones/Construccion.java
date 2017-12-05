package modelo.tablero.poseibles.barrios.construcciones;

import modelo.entidades.Jugador;
import modelo.tablero.poseibles.barrios.Barrio;

public abstract class Construccion {

	protected int precioAlquiler;
	protected String unaDescripcion;
	protected int cantPropiedades;
	protected Barrio elBarrio;

	public void cobrarAlquiler(Jugador propietario, Jugador unVisitante){
		unVisitante.pagarA(propietario, this.precioAlquiler);
	}
	
	public String descripcion(){
		return this.unaDescripcion;
	}

	public int cantidadDePropiedades(){
		return this.cantPropiedades;
	}
	
	public abstract Construccion vender();
}
