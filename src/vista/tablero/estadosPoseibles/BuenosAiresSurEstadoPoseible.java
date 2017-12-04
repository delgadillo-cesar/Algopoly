package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioBuenosAiresSur;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class BuenosAiresSurEstadoPoseible extends EstadoVista {

	private BarrioBuenosAiresSur bueSur;
	private boolean habilitarCasilla;
	
	public BuenosAiresSurEstadoPoseible(){
		this.bueSur = (BarrioBuenosAiresSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_SUR);
		this.habilitarCasilla = false;
	}

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = ((this.habilitarCasilla) && (bueSur.propietario() == unJugador));
		this.habilitarCasilla = true;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, bueSur);
	}
}
