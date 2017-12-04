package vista.tablero.estadosComprables;

import controlador.Comprables.OpcionesComprableHandler;
import controlador.Comprables.SantaFeComprableHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.comprables.SantaFeComprable;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SantaFeEstadoComprable extends EstadoVista {
	
	private SantaFeComprable santaFeComprable;
	private boolean habilitarCasilla;
	
	public SantaFeEstadoComprable(){
		this.santaFeComprable = new SantaFeComprable();
		Tablero.getInstance().cambiarCasillaPor(Tablero.CASILLA_SANTA_FE, this.santaFeComprable);
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
		return new OpcionesComprableHandler(imagen, new SantaFeComprableHandler(santaFeComprable));
	}
}
