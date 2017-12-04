package controlador.Comprables;

import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaAysaPoseible;
import modelo.juego.Turno;
import modelo.tablero.Comprable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AysaComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public AysaComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaAysaPoseible vistaAysa = new VistaAysaPoseible();
    	VistaTablero.getInstance().setAysa(vistaAysa);
    }

}
