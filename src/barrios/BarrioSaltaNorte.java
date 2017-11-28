package barrios;

import entidades.Jugador;

public class BarrioSaltaNorte extends BarrioDoble {

	public BarrioSaltaNorte(Jugador propietario) {
		super(propietario);
		this.construcciones = new NoConstruye();
	}
	

	@Override
	public void valoresDeTerreno(Construible unConstruible) {
		unConstruible.costoCosntruccion(0);
		unConstruible.precioAlquiler(2000);	
	}

	@Override
	public void valoresDeUnaCasa(Construible unConstruible) {
		unConstruible.costoCosntruccion(4500);
		unConstruible.precioAlquiler(3250);	
	}

	@Override
	public void valoresDeDosCasas(Construible unConstruible) {
		unConstruible.costoCosntruccion(4500);
		unConstruible.precioAlquiler(3850);	
	}


	@Override
	public void valoresDeHotel(Construible unConstruible) {
		unConstruible.costoCosntruccion(7500);
		unConstruible.precioAlquiler(5500);	
	}

	@Override
	public void valoresDeEdificioHistorico(Construible unConstruible) {
		// TODO Auto-generated method stub
		
	}
	
	public void interactuarCon(Barrio otroBarrio){
		otroBarrio.interactuarConSaltaNorte(this);
	}
	
	public void interactuarConSaltaSur(Barrio otroBarrio){
		this.actualizarConstrucciones(otroBarrio);
	}	
}
