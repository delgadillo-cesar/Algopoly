package controlador;

import modelo.entidades.Jugador;
import modelo.juego.Dados;
import modelo.juego.Turno;
import modelo.tablero.Tablero;
import vista.Algopoly;
import vista.tablero.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TirarDadosHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		Dados.getInstance().lanzarDados();
		Algopoly.getInstance().tirarDadosSetDisable(true);
		Algopoly.getInstance().redibujar();
		VistaTablero.getInstance().moverJugadrDeTurno(Dados.getInstance().getValor());
	}

}
