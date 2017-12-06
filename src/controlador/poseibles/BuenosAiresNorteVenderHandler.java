package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.tablero.Poseible;
import modelo.tablero.Tablero;
import vista.tablero.VistaTablero;
import vista.tablero.estadosComprables.BuenosAiresNorteEstadoComprable;

public class BuenosAiresNorteVenderHandler implements EventHandler<ActionEvent> {

	Poseible unPoseible;
	
	public BuenosAiresNorteVenderHandler(Poseible unPoseible){
		this.unPoseible = unPoseible;
	}
	
	@Override
	public void handle(ActionEvent event) {
    	this.unPoseible.vender();
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_NORTE).cambiarEstado(new BuenosAiresNorteEstadoComprable());
	}

}
