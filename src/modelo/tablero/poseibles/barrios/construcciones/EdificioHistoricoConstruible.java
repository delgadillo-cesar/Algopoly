package modelo.tablero.poseibles.barrios.construcciones;

import modelo.entidades.Banco;
import modelo.tablero.poseibles.barrios.Barrio;


public class EdificioHistoricoConstruible implements Construible {
	
	private int precioAlquiler;
	private int costoConstuccion;
	private String unaDescripcion;

	public EdificioHistoricoConstruible(){
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
		return new EdificioHistoricoConstruido(unBarrio, this.unaDescripcion, this.precioAlquiler);
	}

	public int costoConstruccionEn(Barrio unBarrio) {
		unBarrio.valoresDeEdificioHistorico(this);
		return this.costoConstuccion;
	}
}
