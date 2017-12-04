package vista.tablero.estadosComprables;

import controlador.Comprables.CordobaNorteComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.CordobaNorteComprable;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class CordobaNorteEstadoComprable extends EstadoVista {
	
	private CordobaNorteComprable cordobaNorteComprable;
	private boolean habilitarCasilla;
	
	public CordobaNorteEstadoComprable(){
		this.cordobaNorteComprable = new CordobaNorteComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_NORTE, this.cordobaNorteComprable);
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
		return new OpcionesComprableHandler(imagen, new CordobaNorteComprableHandler(cordobaNorteComprable));
	}
}
