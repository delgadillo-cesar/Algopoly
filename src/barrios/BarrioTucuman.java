package barrios;

import java.util.HashMap;

import comprables.Barrio;

public class BarrioTucuman  extends Barrio {

	private static String tag = "TUCUMAN";

	public BarrioTucuman() {
		Terreno terreno = new Terreno(1800);
		EdificioHistorico unEdificio = new EdificioHistorico(7000, 4500, "la casita de Tucumán");
		
		this.construcciones = new HashMap<Construible,Construible>();
		this.construcciones.put(terreno, unEdificio);
		this.precioCompra = 17000;
		this.nombrePropiedad = "TUCUMAN";
		this.descripcion =  "TUCUMAN";
		this.construido = terreno.construirEn(this);
	}
	
	public static String getTag(){
		return tag;
	}
}
