package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioTucuman;

public class TucumanEstadoPoseible extends BarrioEstadoVistaPoseible {

	public TucumanEstadoPoseible(){
		this.barrio = (BarrioTucuman) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_TUCUMAN);
		this.habilitarCasilla = false;
	}
}
