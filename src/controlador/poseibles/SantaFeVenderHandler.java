package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.tablero.Poseible;
import modelo.tablero.Tablero;
import vista.tablero.VistaTablero;
import vista.tablero.estadosComprables.SantaFeEstadoComprable;

public class SantaFeVenderHandler implements EventHandler<ActionEvent> {

	Poseible unPoseible;
	
	public SantaFeVenderHandler(Poseible unPoseible){
		this.unPoseible = unPoseible;
	}
	
	@Override
	public void handle(ActionEvent event) {
    	this.unPoseible.vender();
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_SANTA_FE).cambiarEstado(new SantaFeEstadoComprable());
	}

}
