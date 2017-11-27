package barrios;

import java.util.HashMap;

import poseibles.Barrio;


public class BarrioNeuquen extends Barrio {

	private static String tag = "NEUQUEN";

	public BarrioNeuquen() {
		Terreno terreno = new Terreno(1800);
		UnaCasa unaCasa = new UnaCasa(4800, 3800);
		
		this.construcciones = new HashMap<Construible,Construible>();
		this.construcciones.put(terreno, unaCasa);
		this.precioCompra = 17000;
		this.nombrePropiedad = "NEUQUEN";
		this.descripcion =  "NEUQUEN";
		this.construido = terreno.construirEn(this);
	}
	
	public static String getTag(){
		return tag;
	}
}
