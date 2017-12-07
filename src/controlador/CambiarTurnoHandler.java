package controlador;

import vista.Algopoly;
import vista.tablero.VistaTablero;
import modelo.entidades.Jugador;
import modelo.juego.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CambiarTurnoHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		Jugador unJugador = Turno.getInstance().cambiarTurno();
		VistaTablero.getInstance().habilitarCasillas(unJugador);
		Algopoly.getInstance().tirarDadosSetDisable(false);
		Algopoly.getInstance().terminarTurnoSetDisable(true);
		Algopoly.getInstance().redibujar();
	}

}
