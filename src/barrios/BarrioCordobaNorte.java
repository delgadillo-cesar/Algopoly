package barrios;

import java.util.HashMap;

import entidades.Jugador;

public class BarrioCordobaNorte extends BarrioDoble {

	private static String tag = "CORDOBA_NORTE";

	public BarrioCordobaNorte(Jugador propietario) {
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
		
		
		this.construido = terreno.construirEn(this);
		this.propietario = propietario;
	}
	
	public static String getTag(){
		return tag;
	}
}
