package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioSaltaSur;

public class SaltaSurEstadoPoseible extends BarrioEstadoVistaPoseible {

	public SaltaSurEstadoPoseible(){
		this.barrio = (BarrioSaltaSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SALTA_SUR);
		this.habilitarCasilla = false;
	}
}
