package modelo.tablero.poseibles.barrios.construcciones;

import modelo.entidades.Banco;
import modelo.tablero.poseibles.barrios.Barrio;

public class TerrenoConstruible implements Construible {
	private int precioAlquiler;
	private String unaDescripcion;

	public TerrenoConstruible(){
		this.unaDescripcion = "un terreno";
	}


	public void precioAlquiler(int precio) {
		this.precioAlquiler = precio;
	}

	public void costoCosntruccion(int costo) {
	}

	public String descripcion() {
		return this.unaDescripcion;
	}

	public Construccion construirEn(Barrio unBarrio) {
		unBarrio.valoresDeTerreno(this);
		unBarrio.propietario().pagarA(Banco.getInstance(), 0);
		return new TerrenoConstruido(this.precioAlquiler);
	}

	public int costoConstruccionEn(Barrio unBarrio) {
		return 0;
	}
}
