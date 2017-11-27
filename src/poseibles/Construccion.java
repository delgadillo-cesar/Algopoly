package poseibles;

import barrios.Construible;

public class Construccion {

	private int precioAlquiler;
	private String unaDescripcion;
	private Construible constructor;
	private int cantPropiedades;
	
	public Construccion(String unaDescripcion, int precioAlquiler, Construible unConstructor, int cantPropiedades){
		this.precioAlquiler = precioAlquiler;
		this.unaDescripcion = unaDescripcion;
		this.constructor = unConstructor;
		this.cantPropiedades = cantPropiedades;
	}
	
	
	public int precioAlquiler(){
		return this.precioAlquiler;
	}

	public String descripcion(){
		return this.unaDescripcion;
	}
	
	public Construible construidoPor(){
		return this.constructor;
	}
	
	public int cantidadDePropiedades(){
		return this.cantPropiedades;
	}
}
