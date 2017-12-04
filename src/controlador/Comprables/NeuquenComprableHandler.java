package controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaNeuquenPoseible;

public class NeuquenComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public NeuquenComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaNeuquenPoseible vistaNeuquen = new VistaNeuquenPoseible();
    	VistaTablero.getInstance().setNeuquen(vistaNeuquen);
    }

}
