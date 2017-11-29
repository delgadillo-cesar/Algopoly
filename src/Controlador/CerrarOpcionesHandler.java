package Controlador;

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
    	System.out.println("Este funciona");
    	this.stage.close();
    	this.elEventHandler.handle(actionEvent);
    }

}
