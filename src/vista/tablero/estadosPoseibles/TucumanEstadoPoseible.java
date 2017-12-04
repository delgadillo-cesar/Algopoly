package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioTucuman;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;

public class TucumanEstadoPoseible extends EstadoVista {

	private BarrioTucuman tucuman;
	private boolean habilitarCasilla;
	
	public TucumanEstadoPoseible(){
		this.tucuman = (BarrioTucuman) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_TUCUMAN);
		this.habilitarCasilla = false;
	}

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = ((this.habilitarCasilla) && (tucuman.propietario() == unJugador));
		this.habilitarCasilla = true;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, tucuman);
	}
}
