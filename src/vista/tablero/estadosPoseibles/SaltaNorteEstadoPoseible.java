package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioSaltaNorte;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SaltaNorteEstadoPoseible extends EstadoVista {

	private BarrioSaltaNorte saltaNorte;
	private boolean habilitarCasilla;
	
	public SaltaNorteEstadoPoseible(){
		this.saltaNorte = (BarrioSaltaNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SALTA_NORTE);
		this.habilitarCasilla = false;
	}

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = ((this.habilitarCasilla) && (saltaNorte.propietario() == unJugador));
		this.habilitarCasilla = true;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, saltaNorte);
	}
}
