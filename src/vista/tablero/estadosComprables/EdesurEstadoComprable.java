package vista.tablero.estadosComprables;

import controlador.Comprables.EdesurComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.EdesurComprable;

public class EdesurEstadoComprable extends EstadoVista {
	
	private EdesurComprable edesurComprable;
	private boolean habilitarCasilla;
	
	public EdesurEstadoComprable(){
		this.edesurComprable = new EdesurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_EDESUR, this.edesurComprable);
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
		return new OpcionesComprableHandler(imagen, new EdesurComprableHandler(edesurComprable));
	}
}
