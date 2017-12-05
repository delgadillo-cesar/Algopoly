package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioSantaFe;

public class SantaFeEstadoPoseible extends BarrioEstadoVistaPoseible {

	public SantaFeEstadoPoseible(){
		this.barrio = (BarrioSantaFe) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SANTA_FE);
		this.habilitarCasilla = false;
	}
}
