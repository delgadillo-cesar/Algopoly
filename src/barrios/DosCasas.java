package barrios;

import entidades.Banco;
import poseibles.Barrio;
import poseibles.Construccion;

public class DosCasas implements Construible {

	private int precioAlquiler;
	private int costoConstuccion;
	private String unaDescripcion;

	public DosCasas() {
		this.unaDescripcion = "dos casas";
	}

	@Override
	public void precioAlquiler(int precio) {
		this.precioAlquiler = precio;
	}

	@Override
	public void costoCosntruccion(int costo) {
		this.costoConstuccion = costo;
	}

	public String descripcion() {
		return this.unaDescripcion;
	}

	public Construccion construirEn(Barrio unBarrio) {
		unBarrio.valoresDeDosCasas(this);
		unBarrio.propietario().pagarA(Banco.getInstance(), this.costoConstuccion);
		return new Construccion(this.descripcion(), this.precioAlquiler, this,1);
	}

	@Override
	public int costoConstruccionEn(Barrio unBarrio) {
		unBarrio.valoresDeDosCasas(this);
		return this.costoConstuccion;
	}
}
