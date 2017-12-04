package controlador.Comprables;

import modelo.juego.Turno;
import modelo.tablero.Comprable;
import vista.tablero.VistaTablero;
import vista.tablero.poseibles.VistaCordobaNortePoseible;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CordobaNorteComprableHandler implements EventHandler<ActionEvent> {

	Comprable unComprable;
	
	public CordobaNorteComprableHandler(Comprable unComprable){
		this.unComprable = unComprable;
	}
	
	
    public void handle(ActionEvent actionEvent) {
    	this.unComprable.comprar(Turno.getInstance().turnoActual());

    	VistaCordobaNortePoseible vistaCordobaNorte = new VistaCordobaNortePoseible();
    	VistaTablero.getInstance().setCordobaNorte(vistaCordobaNorte);
    }

}
