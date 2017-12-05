package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioBuenosAiresNorte;

public class BuenosAiresNorteEstadoPoseible extends BarrioEstadoVistaPoseible {
	
	public BuenosAiresNorteEstadoPoseible(){
		this.barrio = (BarrioBuenosAiresNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_NORTE);
		this.habilitarCasilla = false;
	}
}
