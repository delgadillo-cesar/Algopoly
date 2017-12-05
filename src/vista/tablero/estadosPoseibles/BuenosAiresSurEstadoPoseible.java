package vista.tablero.estadosPoseibles;

import modelo.tablero.Tablero;
import modelo.tablero.poseibles.barrios.BarrioBuenosAiresSur;

public class BuenosAiresSurEstadoPoseible extends BarrioEstadoVistaPoseible {

	public BuenosAiresSurEstadoPoseible(){
		this.barrio = (BarrioBuenosAiresSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_SUR);
		this.habilitarCasilla = false;
	}
}
