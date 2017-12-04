package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioCordobaNorte;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class CordobaNorteEstadoPoseible extends EstadoVista {

	private BarrioCordobaNorte cordNorte;
	private boolean habilitarCasilla;
	
	public CordobaNorteEstadoPoseible(){
		this.cordNorte = (BarrioCordobaNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_NORTE);
		this.habilitarCasilla = false;
	}

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = ((this.habilitarCasilla) && (cordNorte.propietario() == unJugador));
		this.habilitarCasilla = true;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, cordNorte);
	}
}
