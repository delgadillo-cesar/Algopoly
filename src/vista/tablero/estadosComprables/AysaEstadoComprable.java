package vista.tablero.estadosComprables;

import controlador.Comprables.AysaComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.AysaComprable;

public class AysaEstadoComprable extends EstadoVista {
	
	private AysaComprable aysaComprable;
	private boolean habilitarCasilla;
	
	public AysaEstadoComprable(){
		this.aysaComprable = new AysaComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_AYSA, this.aysaComprable);
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
		return new OpcionesComprableHandler(imagen, new AysaComprableHandler(aysaComprable));
	}
}
