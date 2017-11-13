package propiedades;

public class Construccion {

	private int precioAlquiler;
	private int costoConstuccion;
	private String unaDescripcion;
	
	private Construccion(String unaDescripcion, int costoConstuccion, int precioAlquiler){
		this.precioAlquiler = precioAlquiler;
		this.costoConstuccion = costoConstuccion;
		this.unaDescripcion = unaDescripcion;
	}
	
	
	public static Construccion construirUnTerreno(int precioAlquiler){
		return new Construccion("un terreno", 0, precioAlquiler);
	}
	
	public static Construccion construirUnaCasa(int costoConstuccion, int precioAlquiler){
		return new Construccion("una casa", costoConstuccion, precioAlquiler);
	}
	
	public static Construccion construirDosCasa(int costoConstuccion, int precioAlquiler){
		return new Construccion("dos casas", costoConstuccion, precioAlquiler);
	}
	
	public static Construccion construirUnHotel(int costoConstuccion, int precioAlquiler){
		return new Construccion("un hotel", costoConstuccion, precioAlquiler);
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
