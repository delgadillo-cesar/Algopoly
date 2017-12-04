package controlador.poseibles;

import modelo.tablero.casillas.poseibles.barrios.Barrio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BarrioVenderHandler implements EventHandler<ActionEvent> {

	Barrio elBarrio;
	
	public BarrioVenderHandler(Barrio unBarrio) {
		this.elBarrio = unBarrio;
	}

	public void handle(ActionEvent arg0) {
//		elBarrio.vender();
	}

}
