package modelo.tablero.poseibles.barrios.construcciones;

import modelo.entidades.Banco;
import modelo.tablero.poseibles.barrios.Barrio;

public class UnaCasaConstruida extends Construccion {

	public UnaCasaConstruida(Barrio unBarrio, int precioAlquiler){
		this.precioAlquiler = precioAlquiler;
		this.unaDescripcion = "una casa";
		this.cantPropiedades = 1;
		this.elBarrio = unBarrio;
	}
	
	@Override
	public Construccion vender() {
		TerrenoConstruible terreno = new TerrenoConstruible();
		UnaCasaConstruible unaCasa = new UnaCasaConstruible();

		/*Prestamo ficticio del banco para poder construir la construccion resultante de la venta*/
		Banco.getInstance().pagarA(this.elBarrio.propietario(), terreno.costoConstruccionEn(this.elBarrio));

		/*Pago por la venta*/
		Banco.getInstance().pagarA(this.elBarrio.propietario(), (int) (unaCasa.costoConstruccionEn(this.elBarrio) * 0.85));
		return terreno.construirEn(this.elBarrio);
	}
}
