package vista.tablero.estadosComprables;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import controlador.Comprables.BuenosAiresNorteComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.BuenosAiresNorteComprable;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;

public class BuenosAiresNorteEstadoComprable extends EstadoVista {
	
	private BuenosAiresNorteComprable buenosAiresNorteComprable;
	private boolean habilitarCasilla;
	
	public BuenosAiresNorteEstadoComprable(){
		this.buenosAiresNorteComprable = new BuenosAiresNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_NORTE, this.buenosAiresNorteComprable);
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
		return new OpcionesComprableHandler(imagen, new BuenosAiresNorteComprableHandler(buenosAiresNorteComprable));
	}
}
