package barrios;

import entidades.Banco;
import poseibles.Barrio;
import poseibles.Construccion;

public class EdificioHistorico implements Construible {
	
	private int precioAlquiler;
	private int costoConstuccion;
	private String unaDescripcion;

	public EdificioHistorico(){
		this.unaDescripcion = "";
	}

	@Override
	public void precioAlquiler(int precio) {
		this.precioAlquiler = precio;
	}

	@Override
	public void costoCosntruccion(int costo) {
		this.costoConstuccion = costo;
	}

	public void nombreEdificioHistorico(String nombreEdificio) {
		this.unaDescripcion = nombreEdificio;
	}

	public String descripcion() {
		return this.unaDescripcion;
	}

	public Construccion construirEn(Barrio unBarrio) {
		unBarrio.valoresDeEdificioHistorico(this);
		unBarrio.propietario().pagarA(Banco.getInstance(), this.costoConstuccion);
		return new Construccion(this.descripcion(), this.precioAlquiler, this,1);
	}

	@Override
	public int costoConstruccionEn(Barrio unBarrio) {
		unBarrio.valoresDeEdificioHistorico(this);
		return this.costoConstuccion;
	}
}
