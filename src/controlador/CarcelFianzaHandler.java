package controlador;

import vista.jugador.AlertaSaldoInsuficiente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.entidades.Jugador;
import modelo.entidades.JugadorSinSaldoException;
import modelo.tablero.Tablero;
import modelo.tablero.acciones.Carcel;

public class CarcelFianzaHandler implements EventHandler<ActionEvent> {

	private Jugador elJugdor;

	public CarcelFianzaHandler(Jugador unJugador){
		this.elJugdor= unJugador;
	}

	@Override
	public void handle(ActionEvent event) {
	    Carcel laCarcel= (Carcel)Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CARCEL);
		try{
		    laCarcel.pagarFianzaDeJugador(elJugdor);
		}catch(JugadorSinSaldoException e){
			new AlertaSaldoInsuficiente();
		}
	}
}
