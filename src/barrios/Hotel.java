package barrios;

import poseibles.Barrio;
import poseibles.Construccion;

public class Hotel implements Construible {

	private int precioAlquiler;
	private int costoConstuccion;
	private String unaDescripcion;

	public Hotel(int costoConstuccion, int precioAlquiler){
		this.costoConstuccion = costoConstuccion;
		this.precioAlquiler = precioAlquiler;
		this.unaDescripcion = "hotel";
	}

	
	public int precioAlquiler() {
		return this.precioAlquiler;
	}

	public int costoConstruccion() {
		return this.costoConstuccion;
	}

	public String descripcion() {
		return this.unaDescripcion;
	}

	public Construccion construirEn(Barrio unBarrio) {
		unBarrio.propietario().pagar(this.costoConstuccion);
		return new Construccion(this.descripcion(), this.precioAlquiler, this,1);
	}
}
