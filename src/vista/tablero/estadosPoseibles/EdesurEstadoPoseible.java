package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.Edesur;

public class EdesurEstadoPoseible extends CompaniaEstadoVistaPoseible {

	public EdesurEstadoPoseible(){
		this.poseible = (Edesur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_EDESUR);
		this.habilitarCasilla = false;
	}
}
