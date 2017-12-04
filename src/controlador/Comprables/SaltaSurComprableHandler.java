package controlador.Comprables;

import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaSaltaSurPoseible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SaltaSurComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public SaltaSurComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaSaltaSurPoseible vistaSaltaSur = new VistaSaltaSurPoseible();
    	VistaTablero.getInstance().setSaltaSur(vistaSaltaSur);
    }

}
