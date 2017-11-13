package propiedades;

public class Construccion {

	private int precioAlquiler;
	private int costoConstuccion;
	private String unaDescripcion;
	
	public Construccion(String unaDescripcion, int costoConstuccion, int precioAlquiler){
		this.precioAlquiler = precioAlquiler;
		this.costoConstuccion = costoConstuccion;
		this.unaDescripcion = unaDescripcion;
	}
	
	public int precioAlquiler(){
		return this.precioAlquiler;
	}

	public int costoConstruccion(){
		return this.costoConstuccion;
	}
	
	public String descripcion(){
		return this.unaDescripcion;
	}
}
