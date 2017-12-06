package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.tablero.Poseible;
import modelo.tablero.Tablero;
import vista.tablero.VistaTablero;
import vista.tablero.estadosComprables.BuenosAiresSurEstadoComprable;

public class BuenosAiresSurVenderHandler implements EventHandler<ActionEvent> {

	Poseible unPoseible;
	
	public BuenosAiresSurVenderHandler(Poseible unPoseible){
		this.unPoseible = unPoseible;
	}
	
	@Override
	public void handle(ActionEvent event) {
    	this.unPoseible.vender();
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_SUR).cambiarEstado(new BuenosAiresSurEstadoComprable());
	}

}
