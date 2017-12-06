package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.tablero.Poseible;
import modelo.tablero.Tablero;
import vista.tablero.VistaTablero;
import vista.tablero.estadosComprables.TrenEstadoComprable;

public class TrenVenderHandler implements EventHandler<ActionEvent> {

	Poseible unPoseible;
	
	public TrenVenderHandler(Poseible unPoseible){
		this.unPoseible = unPoseible;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unPoseible.vender();
    	VistaTablero.getInstance().obtenerCasilla(Tablero.CASILLA_TREN).cambiarEstado(new TrenEstadoComprable());
    }
}
