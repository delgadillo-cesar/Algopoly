package barrios;

import java.util.HashMap;

public class BarrioCordobaNorte extends BarrioDoble {

	private static String tag = "CORDOBA_NORTE";

	public BarrioCordobaNorte() {
		Terreno terreno = new Terreno(1300);
		UnaCasa unaCasa = new UnaCasa(2200, 1800);
		DosCasas dosCasas = new DosCasas(2200, 2900);
		Hotel hotel = new Hotel(3500, 3500);
		
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
		this.nombrePropiedad = "CORDOBA NORTE";
		this.descripcion =  "CORDOBA NORTE";
		this.construido = terreno.construirEn(this);
	}
	
	public static String getTag(){
		return tag;
	}
}
