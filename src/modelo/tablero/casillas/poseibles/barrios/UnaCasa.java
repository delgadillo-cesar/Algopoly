package modelo.tablero.casillas.poseibles.barrios;

import modelo.entidades.Banco;

public class UnaCasa implements Construible{

	private int precioAlquiler;
	private int costoConstuccion;
	private String unaDescripcion;

	public UnaCasa(){
		this.unaDescripcion = "una casa";
	}

	public void precioAlquiler(int precio) {
		this.precioAlquiler = precio;
	}

	public void costoCosntruccion(int costo) {
		this.costoConstuccion = costo;
	}

	public String descripcion() {
		return this.unaDescripcion;
	}

	public Construccion construirEn(Barrio unBarrio) {
		unBarrio.valoresDeUnaCasa(this);
		unBarrio.propietario().pagarA(Banco.getInstance(), this.costoConstuccion);
		return new Construccion(this.descripcion(), this.precioAlquiler, this,1);
	}

	public int costoConstruccionEn(Barrio unBarrio) {
		unBarrio.valoresDeUnaCasa(this);
		return this.costoConstuccion;
	}
}
