package controlador.Comprables;

import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaTrenPoseible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TrenComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public TrenComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaTrenPoseible vistaTren = new VistaTrenPoseible();
    	VistaTablero.getInstance().setTren(vistaTren);
    }
}
