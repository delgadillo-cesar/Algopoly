package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.tablero.Poseible;
import modelo.tablero.Tablero;
import vista.tablero.VistaTablero;
import vista.tablero.estadosComprables.NeuquenEstadoComprable;

public class NeuquenVenderHandler implements EventHandler<ActionEvent> {

	Poseible unPoseible;
	
	public NeuquenVenderHandler(Poseible unPoseible){
		this.unPoseible = unPoseible;
	}
	
	@Override
	public void handle(ActionEvent event) {
    	this.unPoseible.vender();
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_NEUQUEN).cambiarEstado(new NeuquenEstadoComprable());
	}

}
