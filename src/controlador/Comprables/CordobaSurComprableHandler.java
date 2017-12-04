package controlador.Comprables;

import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaCordobaSurPoseible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CordobaSurComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public CordobaSurComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaCordobaSurPoseible vistaCordobaSur = new VistaCordobaSurPoseible();
    	VistaTablero.getInstance().setCordobaSur(vistaCordobaSur);
    }

}
