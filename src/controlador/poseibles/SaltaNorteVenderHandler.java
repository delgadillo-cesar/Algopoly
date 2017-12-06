package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.tablero.Poseible;
import modelo.tablero.Tablero;
import vista.tablero.VistaTablero;
import vista.tablero.estadosComprables.SaltaNorteEstadoComprable;

public class SaltaNorteVenderHandler implements EventHandler<ActionEvent> {

	Poseible unPoseible;
	
	public SaltaNorteVenderHandler(Poseible unPoseible){
		this.unPoseible = unPoseible;
	}
	
	@Override
	public void handle(ActionEvent event) {
    	this.unPoseible.vender();
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_SALTA_NORTE).cambiarEstado(new SaltaNorteEstadoComprable());
	}

}
