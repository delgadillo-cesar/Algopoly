package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.tablero.Poseible;
import modelo.tablero.Tablero;
import vista.tablero.VistaTablero;
import vista.tablero.estadosComprables.SubteEstadoComprable;

public class SubteVenderHandler implements EventHandler<ActionEvent> {

	Poseible unPoseible;
	
	public SubteVenderHandler(Poseible unPoseible){
		this.unPoseible = unPoseible;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unPoseible.vender();
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_SUBTE).cambiarEstado(new SubteEstadoComprable());
    }
}
