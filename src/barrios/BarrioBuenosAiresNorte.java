package barrios;

import java.util.HashMap;

public class BarrioBuenosAiresNorte extends BarrioDoble {

	private static String tag = "BUENOS_AIRES_NORTE";

	public BarrioBuenosAiresNorte() {
		Terreno terreno = new Terreno(2500);
		UnaCasa unaCasa = new UnaCasa(5500, 3500);
		DosCasas dosCasas = new DosCasas(5500, 4000);
		Hotel hotel = new Hotel(9000, 6000);
		
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
		
		
		this.precioCompra = 25000;
		this.nombrePropiedad = "BUENOS AIRES NORTE";
		this.descripcion =  "BUENOS AIRES NORTE";
		this.construido = terreno.construirEn(this);
	}
	
	public static String getTag(){
		return tag;
	}
}
