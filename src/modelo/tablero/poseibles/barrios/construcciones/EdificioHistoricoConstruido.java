package modelo.tablero.poseibles.barrios.construcciones;

import modelo.entidades.Banco;
import modelo.tablero.poseibles.barrios.Barrio;

public class EdificioHistoricoConstruido extends Construccion {

	public EdificioHistoricoConstruido(Barrio unBarrio, String unaDescripcion, int precioAlquiler){
		this.precioAlquiler = precioAlquiler;
		this.unaDescripcion = unaDescripcion;
		this.cantPropiedades = 1;
		this.elBarrio = unBarrio;
	}
	
	@Override
	public Construccion vender() {
		TerrenoConstruible terreno = new TerrenoConstruible();
		EdificioHistoricoConstruible edificio = new EdificioHistoricoConstruible();

		/*Prestamo ficticio del banco para poder construir la construccion resultante de la venta*/
		Banco.getInstance().pagarA(this.elBarrio.propietario(), terreno.costoConstruccionEn(this.elBarrio));

		/*Pago por la venta*/
		Banco.getInstance().pagarA(this.elBarrio.propietario(), (int) (edificio.costoConstruccionEn(this.elBarrio) * 0.85));
		return terreno.construirEn(this.elBarrio);
	}

	@Override
	public boolean sePuedeVender() {
		return true;
	}
}
