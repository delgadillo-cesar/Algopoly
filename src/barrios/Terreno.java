package barrios;

import entidades.Banco;
import poseibles.Barrio;
import poseibles.Construccion;

public class Terreno implements Construible {
	private int precioAlquiler;
	private String unaDescripcion;

	public Terreno(){
		this.unaDescripcion = "un terreno";
	}
	@Override
	public void precioAlquiler(int precio) {
		this.precioAlquiler = precio;
	}

	@Override
	public void costoCosntruccion(int costo) {
	}

	public String descripcion() {
		return this.unaDescripcion;
	}

	public Construccion construirEn(Barrio unBarrio) {
		unBarrio.valoresDeTerreno(this);
		unBarrio.propietario().pagarA(Banco.getInstance(), 0);
		return new Construccion(this.descripcion(), this.precioAlquiler, this,1);
	}

	@Override
	public int costoConstruccionEn(Barrio unBarrio) {
		return 0;
	}
}
