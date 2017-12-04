package vista.tablero.estadosComprables;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import controlador.Comprables.BuenosAiresSurComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.BuenosAiresSurComprable;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;

public class BuenosAiresSurEstadoComprable extends EstadoVista {
	
	private BuenosAiresSurComprable buenosAiresSurComprable;
	private boolean habilitarCasilla;
	
	public BuenosAiresSurEstadoComprable(){
		this.buenosAiresSurComprable = new BuenosAiresSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_BUENOS_AIRES_SUR, this.buenosAiresSurComprable);
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
		return new OpcionesComprableHandler(imagen, new BuenosAiresSurComprableHandler(buenosAiresSurComprable));
	}
}
