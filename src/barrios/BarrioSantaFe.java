package barrios;

import java.util.HashMap;

import comprables.Barrio;

public class BarrioSantaFe extends Barrio {

	private static String tag = "SANTA_FE";

	public BarrioSantaFe() {
		Terreno terreno = new Terreno(1500);
		UnaCasa unaCasa = new UnaCasa(4000, 3500);
		
		this.construcciones = new HashMap<Construible,Construible>();
		this.construcciones.put(terreno, unaCasa);
		this.precioCompra = 15000;
		this.nombrePropiedad = "SANTA FE";
		this.descripcion =  "SANTA FE";
		this.construido = terreno.construirEn(this);
	}

	public static String getTag(){
		return tag;
	}

}
