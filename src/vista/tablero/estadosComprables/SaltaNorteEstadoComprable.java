package vista.tablero.estadosComprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.SaltaNorteComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SaltaNorteComprable;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SaltaNorteEstadoComprable extends EstadoVista {
	
	private SaltaNorteComprable saltaNorteComprable;
	private boolean habilitarCasilla;
	
	public SaltaNorteEstadoComprable(){
		this.saltaNorteComprable = new SaltaNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SALTA_NORTE, this.saltaNorteComprable);
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
		return new OpcionesComprableHandler(imagen, new SaltaNorteComprableHandler(saltaNorteComprable));
	}
}
