package modelo.tablero.casillas.poseibles.barrios;

import modelo.entidades.Banco;


public class EdificioHistorico implements Construible {
	
	private int precioAlquiler;
	private int costoConstuccion;
	private String unaDescripcion;

	public EdificioHistorico(){
		this.unaDescripcion = "";
	}

	public void precioAlquiler(int precio) {
		this.precioAlquiler = precio;
	}

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

	public int costoConstruccionEn(Barrio unBarrio) {
		unBarrio.valoresDeEdificioHistorico(this);
		return this.costoConstuccion;
	}
}
