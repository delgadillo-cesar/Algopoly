package barrios;

import comprables.Barrio;
import comprables.Construccion;

public class Terreno implements Construible {
	private int precioAlquiler;
	private int costoConstuccion;
	private String unaDescripcion;

	public Terreno(int precioAlquiler){
		this.costoConstuccion = 0;
		this.precioAlquiler = precioAlquiler;
		this.unaDescripcion = "un terreno";
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
		return new Construccion(this.descripcion(), this.precioAlquiler, this,1);
	}

}
