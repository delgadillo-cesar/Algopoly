package modelo.tablero.poseibles.barrios.construcciones;

import modelo.entidades.Banco;
import modelo.tablero.poseibles.barrios.Barrio;

public class HotelConstruible implements Construible {

	private int precioAlquiler;
	private int costoConstuccion;
	private String unaDescripcion;

	public HotelConstruible(){
		this.unaDescripcion = "hotel";
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
		unBarrio.valoresDeHotel(this);
		unBarrio.propietario().pagarA(Banco.getInstance(), this.costoConstuccion);
		return new HotelConstruido(unBarrio, this.precioAlquiler);
	}

	public int costoConstruccionEn(Barrio unBarrio) {
		unBarrio.valoresDeHotel(this);
		return this.costoConstuccion;
	}
}
