package modelo.tablero.poseibles.barrios.construcciones;

import modelo.entidades.Banco;
import modelo.tablero.poseibles.barrios.Barrio;

public class DosCasasConstruida extends Construccion {

	public DosCasasConstruida(Barrio unBarrio, int precioAlquiler){
		this.precioAlquiler = precioAlquiler;
		this.unaDescripcion = "dos casa";
		this.cantPropiedades = 2;
		this.elBarrio = unBarrio;
	}
	
	@Override
	public Construccion vender() {
		UnaCasaConstruible unaCasa = new UnaCasaConstruible();
		DosCasasConstruible dosCasa = new DosCasasConstruible();

		/*Prestamo ficticio del banco para poder construir la construccion resultante de la venta*/
		Banco.getInstance().pagarA(this.elBarrio.propietario(), unaCasa.costoConstruccionEn(this.elBarrio));

		/*Pago por la venta*/
		Banco.getInstance().pagarA(this.elBarrio.propietario(), (int) (dosCasa.costoConstruccionEn(this.elBarrio) * 0.85));
		return unaCasa.construirEn(this.elBarrio);
	}
}
