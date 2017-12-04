package controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaTucumanPoseible;

public class TucumanComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public TucumanComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaTucumanPoseible vistaTucuman = new VistaTucumanPoseible();
    	VistaTablero.getInstance().setTucuman(vistaTucuman);
    }

}
