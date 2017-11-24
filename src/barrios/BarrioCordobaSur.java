package barrios;

import java.util.HashMap;

public class BarrioCordobaSur extends BarrioDoble {

	private static String tag = "CORDOBA_SUR";

	public BarrioCordobaSur() {
		Terreno terreno = new Terreno(1000);
		UnaCasa unaCasa = new UnaCasa(2000, 1500);
		DosCasas dosCasas = new DosCasas(2000, 2500);
		Hotel hotel = new Hotel(3000, 3000);
		
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
		
		
		this.precioCompra = 18000;
		this.nombrePropiedad = "CORDOBA_SUR";
		this.descripcion =  "CORDOBA_SUR";
		this.construido = terreno.construirEn(this);
	}
	
	public static String getTag(){
		return tag;
	}
}
