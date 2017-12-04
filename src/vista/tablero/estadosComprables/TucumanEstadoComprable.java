package vista.tablero.estadosComprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.TucumanComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.TucumanComprable;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class TucumanEstadoComprable extends EstadoVista {
	
	private TucumanComprable tucumanComprable;
	private boolean habilitarCasilla;
	
	public TucumanEstadoComprable(){
		this.tucumanComprable = new TucumanComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TUCUMAN, this.tucumanComprable);
	}

	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = this.habilitarCasilla;
		this.habilitarCasilla = false;
		return habilitar;
	}
	
	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador){
		this.habilitarCasilla = true;
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesComprableHandler(imagen, new TucumanComprableHandler(tucumanComprable));
	}
}
