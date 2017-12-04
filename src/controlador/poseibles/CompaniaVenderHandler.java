package controlador.poseibles;

import modelo.tablero.casillas.poseibles.Compania;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CompaniaVenderHandler implements EventHandler<ActionEvent> {

	private Compania laCompania;
	
	public CompaniaVenderHandler(Compania unaCompania) {
		this.laCompania = unaCompania;
	}

	public void handle(ActionEvent arg0) {
//		laCompania.vender();
	}

}
