package Controlador.Comprables;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.tablero.comprables.VistaOpcionesComprable;

public class OpcionesComprableHandler implements EventHandler<ActionEvent> {

	EventHandler<ActionEvent> elEventHandler;
	
	public OpcionesComprableHandler(EventHandler<ActionEvent> unEventHandler){
		this.elEventHandler = unEventHandler;
	}

    public void handle(ActionEvent actionEvent) {
    	VistaOpcionesComprable opciones = new VistaOpcionesComprable(elEventHandler);
    	opciones.show();
    }

}
