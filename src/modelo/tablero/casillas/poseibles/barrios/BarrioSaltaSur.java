package modelo.tablero.casillas.poseibles.barrios;

import modelo.entidades.Jugador;

public class BarrioSaltaSur extends BarrioDoble {

	public BarrioSaltaSur(Jugador propietario) {
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
		otroBarrio.interactuarConSaltaSur(this);
	}
	
	public void interactuarConSaltaNorte(Barrio otroBarrio){
		this.actualizarConstrucciones(otroBarrio);
	}	
}
