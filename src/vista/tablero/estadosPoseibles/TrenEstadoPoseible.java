package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.Tren;

public class TrenEstadoPoseible extends CompaniaEstadoVistaPoseible {

	public TrenEstadoPoseible(){
		this.poseible = (Tren) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_TREN);
		this.habilitarCasilla = false;
	}
}
