package barrios;

import java.util.HashMap;

public class BarrioSaltaNorte extends BarrioDoble {

	private static String tag = "SALTA_NORTE";

	public BarrioSaltaNorte() {
		Terreno terreno = new Terreno(2000);
		UnaCasa unaCasa = new UnaCasa(4500, 3250);
		DosCasas dosCasas = new DosCasas(4500, 3850);
		Hotel hotel = new Hotel(7500, 5500);
		
		this.construcciones = new HashMap<Construible,Construible>();
		this.construcciones.put(terreno, unaCasa);
		this.construcciones.put(unaCasa, dosCasas);
		this.construcciones.put(dosCasas, hotel);
		
		this.espacioCompleto = new HashMap<Construible,Boolean>();
		this.espacioCompleto.put(terreno, false);
		this.espacioCompleto.put(unaCasa, false);
		this.espacioCompleto.put(dosCasas, true);
		this.espacioCompleto.put(hotel, true);
		
		this.condicionConstruccion = new HashMap<Construible,CondicionConstruccion>();
		this.condicionConstruccion.put(terreno, new SinCondicion());
		this.condicionConstruccion.put(unaCasa, new SerDuenoDelComplemento());
		this.condicionConstruccion.put(dosCasas, new SerDuenoDelComplemento());
		this.condicionConstruccion.put(hotel, new ComplementoCompleto());
		
		
		this.precioCompra = 23000;
		this.nombrePropiedad = "SALTA NORTE";
		this.descripcion =  "SALTA NORTE";
		this.construido = terreno.construirEn(this);
	}
	
	public static String getTag(){
		return tag;
	}
}
