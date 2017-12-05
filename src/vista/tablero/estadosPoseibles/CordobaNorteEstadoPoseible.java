package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioCordobaNorte;

public class CordobaNorteEstadoPoseible extends BarrioEstadoVistaPoseible {

	public CordobaNorteEstadoPoseible(){
		this.barrio = (BarrioCordobaNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_NORTE);
		this.habilitarCasilla = false;
	}
}
