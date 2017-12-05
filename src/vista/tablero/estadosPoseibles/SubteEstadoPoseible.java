package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.Subte;

public class SubteEstadoPoseible extends CompaniaEstadoVistaPoseible {

	public SubteEstadoPoseible(){
		this.poseible = (Subte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SUBTE);
		this.habilitarCasilla = false;
	}
}
