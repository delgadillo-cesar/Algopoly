package vista.tablero.acciones;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.entidades.Jugador;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;

public class EstadoAccion extends EstadoVista {

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		return false;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return null;
	}

}
