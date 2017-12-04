package vista.tablero.estadosPoseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioSantaFe;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class SantaFeEstadoPoseible extends EstadoVista {

	private BarrioSantaFe santaFe;
	private boolean habilitarCasilla;

	public SantaFeEstadoPoseible(){
		this.santaFe = (BarrioSantaFe) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SANTA_FE);
		this.habilitarCasilla = false;
	}

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = ((this.habilitarCasilla) && (santaFe.propietario() == unJugador));
		this.habilitarCasilla = true;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesBarrioPoseibleHandler(imagen, santaFe);
	}
}
