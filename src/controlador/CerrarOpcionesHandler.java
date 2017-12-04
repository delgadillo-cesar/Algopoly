package controlador;

import vista.Algopoly;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CerrarOpcionesHandler implements EventHandler<ActionEvent> {

	EventHandler<ActionEvent> elEventHandler;
	Stage stage;
	
	public CerrarOpcionesHandler(Stage stage, EventHandler<ActionEvent> unEventHandler){
		this.elEventHandler = unEventHandler;
		this.stage = stage;
	}

    public void handle(ActionEvent actionEvent) {
    	this.stage.close();
    	this.elEventHandler.handle(actionEvent);
    	Algopoly.getInstance().redibujar();
    }
}
