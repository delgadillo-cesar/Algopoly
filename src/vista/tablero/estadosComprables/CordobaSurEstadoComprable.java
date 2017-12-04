package vista.tablero.estadosComprables;

import controlador.Comprables.CordobaSurComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.CordobaSurComprable;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class CordobaSurEstadoComprable extends EstadoVista {
	
	private CordobaSurComprable cordobaSurComprable;
	private boolean habilitarCasilla;
	
	public CordobaSurEstadoComprable(){
		this.cordobaSurComprable = new CordobaSurComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_CORDOBA_SUR, this.cordobaSurComprable);
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
		return new OpcionesComprableHandler(imagen, new CordobaSurComprableHandler(cordobaSurComprable));
	}
}
