package barrios;

import entidades.Jugador;

public class BarrioCordobaNorte extends BarrioDoble {

	public BarrioCordobaNorte(Jugador propietario) {
		super(propietario);
		this.construcciones = new NoConstruye();
	}
	

	@Override
	public void valoresDeTerreno(Construible unConstruible) {
		unConstruible.costoCosntruccion(0);
		unConstruible.precioAlquiler(1300);	
	}

	@Override
	public void valoresDeUnaCasa(Construible unConstruible) {
		unConstruible.costoCosntruccion(2200);
		unConstruible.precioAlquiler(1800);	
	}

	@Override
	public void valoresDeDosCasas(Construible unConstruible) {
		unConstruible.costoCosntruccion(2200);
		unConstruible.precioAlquiler(2900);	
	}


	@Override
	public void valoresDeHotel(Construible unConstruible) {
		unConstruible.costoCosntruccion(3500);
		unConstruible.precioAlquiler(3500);	
	}

	@Override
	public void valoresDeEdificioHistorico(Construible unConstruible) {
		// TODO Auto-generated method stub
		
	}
	
	public void interactuarCon(Barrio otroBarrio){
		otroBarrio.interactuarConCordobaNorte(this);
	}
	
	public void interactuarConCordobaSur(Barrio otroBarrio){
		this.actualizarConstrucciones(otroBarrio);
	}
}
