package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioBuenosAiresNorte;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class BuenosAiresNorteEstadoPoseible extends EstadoVista {

	private BarrioBuenosAiresNorte bueNor;
	private boolean habilitarCasilla;
	
	public BuenosAiresNorteEstadoPoseible(){
		this.bueNor = (BarrioBuenosAiresNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_NORTE);
		this.habilitarCasilla = false;
	}

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = ((this.habilitarCasilla) && (bueNor.propietario() == unJugador));
		this.habilitarCasilla = true;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, bueNor);
	}
}
