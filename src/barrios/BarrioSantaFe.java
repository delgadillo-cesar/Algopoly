package barrios;

import entidades.Jugador;
import poseibles.Barrio;


public class BarrioSantaFe extends Barrio {

	public BarrioSantaFe(Jugador propietario) {
		super(propietario);

		this.construcciones = new SoloCasa();
	}

	@Override
	public void valoresDeTerreno(Construible unConstruible) {
		unConstruible.costoCosntruccion(0);
		unConstruible.precioAlquiler(1500);	
	}

	@Override
	public void valoresDeUnaCasa(Construible unConstruible) {
		unConstruible.costoCosntruccion(4000);
		unConstruible.precioAlquiler(3500);	
	}

	@Override
	public void valoresDeDosCasas(Construible unConstruible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valoresDeHotel(Construible unConstruible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valoresDeEdificioHistorico(Construible unConstruible) {
		// TODO Auto-generated method stub
		
	}

}
