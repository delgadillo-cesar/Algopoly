package controlador;

import vista.Algopoly;
import vista.jugador.AlertaSaldoInsuficiente;
import modelo.entidades.Jugador;
import modelo.entidades.JugadorSinSaldoException;
import modelo.juego.Turno;
import modelo.tablero.Casilla;
import modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PagarPendienteHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		Jugador jugadorActual = Turno.getInstance().turnoActual();
		Tablero tablero = Tablero.getInstance();
		Casilla casilla = tablero.obtenerCasilla(tablero.casillaDeJugador(jugadorActual));

		System.out.println("Handler");


		try{
			casilla.afectar(jugadorActual);
			Algopoly.getInstance().pendientePagado();
			
			EventHandler<ActionEvent> cambiarTurno = new CambiarTurnoHandler();
			cambiarTurno.handle(arg0);
		}catch(JugadorSinSaldoException e){
			new AlertaSaldoInsuficiente();
		}
		
	}

}
