package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.tablero.poseibles.Compania;

public class CompaniaVenderHandler implements EventHandler<ActionEvent> {

	private Compania laCompania;
	
	public CompaniaVenderHandler(Compania unaCompania) {
		this.laCompania = unaCompania;
	}

	public void handle(ActionEvent arg0) {
//		laCompania.vender();
	}

}
