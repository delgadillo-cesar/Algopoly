package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesCompaniaPoseibleHandler;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.Edesur;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class EdesurEstadoPoseible extends EstadoVista {

	private Edesur edesur;
	private boolean habilitarCasilla;
	
	public EdesurEstadoPoseible(){
		this.edesur = (Edesur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_EDESUR);
		this.habilitarCasilla = false;
	}

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = ((this.habilitarCasilla) && (edesur.propietario() == unJugador));
		this.habilitarCasilla = true;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesCompaniaPoseibleHandler(imagen, edesur);
	}
}
