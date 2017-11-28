package barrios;

import entidades.Jugador;

public class BarrioBuenosAiresNorte extends BarrioDoble {

	public BarrioBuenosAiresNorte(Jugador propietario) {
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
		otroBarrio.interactuarConBuenosAiresNorte(this);
	}
	
	public void interactuarConBuenosAiresSur(Barrio otroBarrio){
		this.actualizarConstrucciones(otroBarrio);
	}
}
