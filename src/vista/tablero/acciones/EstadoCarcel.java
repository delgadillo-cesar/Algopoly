package vista.tablero.acciones;

import controlador.OpcionesCarcelHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.acciones.Carcel;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;

public class EstadoCarcel extends EstadoVista {


	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
	    Carcel laCarcel= (Carcel)Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CARCEL);
	    
		return laCarcel.estaPreso(unJugador);
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesCarcelHandler(imagen);
	}
}
