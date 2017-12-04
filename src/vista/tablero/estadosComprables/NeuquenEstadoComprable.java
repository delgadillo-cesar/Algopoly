package vista.tablero.estadosComprables;

import controlador.Comprables.NeuquenComprableHandler;
import controlador.Comprables.OpcionesComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.NeuquenComprable;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class NeuquenEstadoComprable extends EstadoVista {
	
	private NeuquenComprable neuquenComprable;
	private boolean habilitarCasilla;
	
	public NeuquenEstadoComprable(){
		this.neuquenComprable = new NeuquenComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_NEUQUEN, this.neuquenComprable);
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
		return new OpcionesComprableHandler(imagen, new NeuquenComprableHandler(neuquenComprable));
	}
}
