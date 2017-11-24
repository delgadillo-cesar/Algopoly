package barrios;

import java.util.HashMap;

public class BarrioBuenosAiresSur extends BarrioDoble {

	private static String tag = "BUENOS_AIRES_SUR";

	public BarrioBuenosAiresSur() {
		Terreno terreno = new Terreno(2000);
		UnaCasa unaCasa = new UnaCasa(5000, 3000);
		DosCasas dosCasas = new DosCasas(5000, 3500);
		Hotel hotel = new Hotel(8000, 5000);
		
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
		
		
		this.precioCompra = 20000;
		this.nombrePropiedad = "BUENOS_AIRES_SUR";
		this.descripcion =  "BUENOS_AIRES_SUR";
		this.construido = terreno.construirEn(this);
	}
	
	public static String getTag(){
		return tag;
	}
}
