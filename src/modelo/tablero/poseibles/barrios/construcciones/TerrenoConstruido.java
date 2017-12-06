package modelo.tablero.poseibles.barrios.construcciones;

public class TerrenoConstruido extends Construccion {

	public TerrenoConstruido(int precioAlquiler){
		this.precioAlquiler = precioAlquiler;
		this.unaDescripcion = "un terreno";
		this.cantPropiedades = 1;
	}
	
	
	@Override
	public Construccion vender() {
		return null;
	}


	@Override
	public boolean sePuedeVender() {
		return false;
	}

}
