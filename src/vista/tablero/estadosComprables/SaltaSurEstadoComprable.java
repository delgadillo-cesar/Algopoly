package vista.tablero.estadosComprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.SaltaSurComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SaltaSurComprable;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SaltaSurEstadoComprable extends EstadoVista {
	
	private SaltaSurComprable saltaSurComprable;
	private boolean habilitarCasilla;
	
	public SaltaSurEstadoComprable(){
		this.saltaSurComprable = new SaltaSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_SUR, this.saltaSurComprable);
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
		return new OpcionesComprableHandler(imagen, new SaltaSurComprableHandler(saltaSurComprable));
	}
}
