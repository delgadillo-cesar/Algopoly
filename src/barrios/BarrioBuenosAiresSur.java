package barrios;

import entidades.Jugador;

public class BarrioBuenosAiresSur extends BarrioDoble {

	public BarrioBuenosAiresSur(Jugador propietario) {
		super(propietario);
		this.construcciones = new NoConstruye();
	}

	@Override
	public void valoresDeTerreno(Construible unConstruible) {
		unConstruible.costoCosntruccion(0);
		unConstruible.precioAlquiler(2500);	
	}

	@Override
	public void valoresDeUnaCasa(Construible unConstruible) {
		unConstruible.costoCosntruccion(5500);
		unConstruible.precioAlquiler(3500);	
	}

	@Override
	public void valoresDeDosCasas(Construible unConstruible) {
		unConstruible.costoCosntruccion(5500);
		unConstruible.precioAlquiler(4000);	
	}


	@Override
	public void valoresDeHotel(Construible unConstruible) {
		unConstruible.costoCosntruccion(9000);
		unConstruible.precioAlquiler(6000);	
	}

	@Override
	public void valoresDeEdificioHistorico(Construible unConstruible) {
		// TODO Auto-generated method stub
		
	}
	
	public void interactuarCon(Barrio otroBarrio){
		otroBarrio.interactuarConBuenosAiresSur(this);
	}
	
	public void interactuarConBuenosAiresNorte(Barrio otroBarrio){
		this.actualizarConstrucciones(otroBarrio);
	}
}
