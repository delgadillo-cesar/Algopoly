package vista.tablero;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.entidades.Jugador;
import vista.jugador.VistaJugador;

public abstract class EstadoVista {

	public abstract boolean habilitarParaJugador(Jugador unJugador);
	public abstract void jugadorCayoEnCasilla(VistaJugador unJugador);
	public abstract EventHandler<MouseEvent> obtenerHandler(Image imagen);
	public abstract void dibujame(VistaCasilla vistaCasilla);

}
