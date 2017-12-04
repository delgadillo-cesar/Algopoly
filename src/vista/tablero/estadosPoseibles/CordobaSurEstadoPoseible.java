package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioCordobaSur;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;

public class CordobaSurEstadoPoseible extends EstadoVista {

	private BarrioCordobaSur cordSur;
	private boolean habilitarCasilla;
	
	public CordobaSurEstadoPoseible(){
		this.cordSur = (BarrioCordobaSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_SUR);
		this.habilitarCasilla = false;
	}

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = ((this.habilitarCasilla) && (cordSur.propietario() == unJugador));
		this.habilitarCasilla = true;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, cordSur);
	}
}
