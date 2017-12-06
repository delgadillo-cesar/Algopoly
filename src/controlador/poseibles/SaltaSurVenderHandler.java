package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.tablero.Poseible;
import modelo.tablero.Tablero;
import vista.tablero.VistaTablero;
import vista.tablero.estadosComprables.SaltaSurEstadoComprable;

public class SaltaSurVenderHandler implements EventHandler<ActionEvent> {

	Poseible unPoseible;
	
	public SaltaSurVenderHandler(Poseible unPoseible){
		this.unPoseible = unPoseible;
	}
	
	@Override
	public void handle(ActionEvent event) {
    	this.unPoseible.vender();
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_SALTA_SUR).cambiarEstado(new SaltaSurEstadoComprable());
	}

}
