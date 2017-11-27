package barrios;

import entidades.Jugador;
import poseibles.Barrio;


public class BarrioTucuman  extends Barrio {

	public BarrioTucuman(Jugador propietario) {
		super(propietario);

		this.construcciones = new SoloCasa();
	}
	
	@Override
	public void valoresDeTerreno(Construible unConstruible) {
		unConstruible.costoCosntruccion(0);
		unConstruible.precioAlquiler(1800);	
	}

	@Override
	public void valoresDeUnaCasa(Construible unConstruible) {
		// TODO Auto-generated method stub
		
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
		unConstruible.costoCosntruccion(7000);
		unConstruible.precioAlquiler(4500);
		((EdificioHistorico) unConstruible).nombreEdificioHistorico("la casita de Tucumán");
	}
}
