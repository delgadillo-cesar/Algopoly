package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioSaltaNorte;

public class SaltaNorteEstadoPoseible extends BarrioEstadoVistaPoseible {

	public SaltaNorteEstadoPoseible(){
		this.barrio = (BarrioSaltaNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SALTA_NORTE);
		this.habilitarCasilla = false;
	}
}
