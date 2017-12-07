package controlador.poseibles;

import vista.jugador.AlertaSaldoInsuficiente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.entidades.JugadorSinSaldoException;
import modelo.tablero.poseibles.barrios.Barrio;

public class BarrioConstruirHandler implements EventHandler<ActionEvent> {

	Barrio elBarrio;
	
	public BarrioConstruirHandler(Barrio unBarrio) {
		this.elBarrio = unBarrio;
	}

	public void handle(ActionEvent arg0) {
		try{
			elBarrio.construir();
		}catch(JugadorSinSaldoException e){
			new AlertaSaldoInsuficiente();
		}
	}

}
