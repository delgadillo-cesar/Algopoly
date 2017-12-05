package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioCordobaSur;

public class CordobaSurEstadoPoseible extends BarrioEstadoVistaPoseible {

	public CordobaSurEstadoPoseible(){
		this.barrio = (BarrioCordobaSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_SUR);
		this.habilitarCasilla = false;
	}
}
