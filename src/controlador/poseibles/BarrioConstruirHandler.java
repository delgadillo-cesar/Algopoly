package controlador.poseibles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.tablero.poseibles.barrios.Barrio;

public class BarrioConstruirHandler implements EventHandler<ActionEvent> {

	Barrio elBarrio;
	
	public BarrioConstruirHandler(Barrio unBarrio) {
		this.elBarrio = unBarrio;
	}

	public void handle(ActionEvent arg0) {
		elBarrio.construir();
	}

}
