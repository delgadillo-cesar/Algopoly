package controlador.Comprables;

import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaEdesurPoseible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EdesurComprableHandler implements EventHandler<ActionEvent> {


	Comprable unComprable;
	
	public EdesurComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaEdesurPoseible vistaEdesur = new VistaEdesurPoseible();
    	VistaTablero.getInstance().setEdesur(vistaEdesur);
    }
}
