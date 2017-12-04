package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesCompaniaPoseibleHandler;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.Aysa;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class AysaEstadoPoseible extends EstadoVista {

	private Aysa aysa;
	private boolean habilitarCasilla;
	
	public AysaEstadoPoseible(){
		this.aysa = (Aysa) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_AYSA);
		this.habilitarCasilla = false;
	}

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = ((this.habilitarCasilla) && (aysa.propietario() == unJugador));
		this.habilitarCasilla = true;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesCompaniaPoseibleHandler(imagen, aysa);
	}
}
