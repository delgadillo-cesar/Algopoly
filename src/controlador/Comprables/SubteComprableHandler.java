package controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaSubtePoseible;

public class SubteComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public SubteComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaSubtePoseible vistaSubte = new VistaSubtePoseible();
    	VistaTablero.getInstance().setSubte(vistaSubte);
    }
}
