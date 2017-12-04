package vista.tablero.estadosComprables;

import controlador.Comprables.TrenComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.TrenComprable;

public class TrenEstadoComprable extends EstadoVista {
	
	private TrenComprable trenComprable;
	private boolean habilitarCasilla;
	
	public TrenEstadoComprable(){
		this.trenComprable = new TrenComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_TREN, this.trenComprable);
	}
	
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = this.habilitarCasilla;
		this.habilitarCasilla = false;
		return habilitar;
	}
	
	public void jugadorCayoEnCasilla(VistaJugador unJugador){
		this.habilitarCasilla = true;
	}
	
	public EventHandler<MouseEvent> obtenerHandler(Image imagen){
		return new OpcionesComprableHandler(imagen, new TrenComprableHandler(trenComprable));
	}
}
