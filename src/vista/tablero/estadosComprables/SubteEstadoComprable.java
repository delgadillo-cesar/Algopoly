package vista.tablero.estadosComprables;

import controlador.Comprables.SubteComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SubteComprable;

public class SubteEstadoComprable extends EstadoVista {
	
	private SubteComprable subteComprable;
	private boolean habilitarCasilla;
	
	public SubteEstadoComprable(){
		this.subteComprable = new SubteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SUBTE, this.subteComprable);
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
		return new OpcionesComprableHandler(imagen, new SubteComprableHandler(subteComprable));
	}
}
