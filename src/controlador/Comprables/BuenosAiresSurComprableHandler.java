package controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaBuenosAiresSurPoseible;

public class BuenosAiresSurComprableHandler  implements EventHandler<ActionEvent> {


	Comprable unComprable;
	
	public BuenosAiresSurComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	
    	VistaBuenosAiresSurPoseible vistaBuenosAiresSurr = new VistaBuenosAiresSurPoseible();
    	VistaTablero.getInstance().setBuenosAiresSur(vistaBuenosAiresSurr);
    }

}
