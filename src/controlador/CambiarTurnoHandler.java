package controlador;

import vista.Algopoly;
import modelo.juego.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CambiarTurnoHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		Turno.getInstance().cambiarTurno();
		Algopoly.getInstance().tirarDadosSetDisable(false);
		Algopoly.getInstance().terminarTurnoSetDisable(true);
		Algopoly.getInstance().redibujar();
	}

}
