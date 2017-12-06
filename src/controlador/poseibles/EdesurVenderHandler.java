package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.tablero.Poseible;
import modelo.tablero.Tablero;
import vista.tablero.VistaTablero;
import vista.tablero.estadosComprables.EdesurEstadoComprable;

public class EdesurVenderHandler implements EventHandler<ActionEvent> {

	Poseible unPoseible;
	
	public EdesurVenderHandler(Poseible unPoseible){
		this.unPoseible = unPoseible;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unPoseible.vender();
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_EDESUR).cambiarEstado(new EdesurEstadoComprable());
    }
}
