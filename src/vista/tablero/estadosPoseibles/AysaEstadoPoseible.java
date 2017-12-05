package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.Aysa;

public class AysaEstadoPoseible extends CompaniaEstadoVistaPoseible {
	
	public AysaEstadoPoseible(){
		this.poseible = (Aysa) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_AYSA);
		this.habilitarCasilla = false;
	}

}
