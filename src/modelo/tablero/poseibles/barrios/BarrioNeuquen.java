package modelo.tablero.poseibles.barrios;

import modelo.entidades.Jugador;
import modelo.tablero.poseibles.barrios.construcciones.Construible;
import modelo.tablero.poseibles.barrios.construcciones.SoloCasa;


public class BarrioNeuquen extends Barrio {

	public BarrioNeuquen(Jugador propietario) {
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
		unConstruible.costoCosntruccion(4800);
		unConstruible.precioAlquiler(3800);	
	}

	@Override
	public void valoresDeDosCasas(Construible unConstruible) {
	}

	@Override
	public void valoresDeHotel(Construible unConstruible) {
	}

	@Override
	public void valoresDeEdificioHistorico(Construible unConstruible) {
	}
}
