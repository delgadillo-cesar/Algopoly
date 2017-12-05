package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioNeuquen;

public class NeuquenEstadoPoseible extends BarrioEstadoVistaPoseible {

	public NeuquenEstadoPoseible(){
		this.barrio = (BarrioNeuquen) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_NEUQUEN);
		this.habilitarCasilla = false;
	}
}
