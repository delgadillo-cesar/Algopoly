package vista.tablero.estadosPoseibles;

import modelo.entidades.Jugador;
import modelo.tablero.Poseible;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import vista.tablero.VistaCasilla;

public abstract class CompaniaEstadoVistaPoseible extends EstadoVista {

	protected Poseible poseible;
	protected boolean habilitarCasilla;

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = ((this.habilitarCasilla) && (this.poseible.propietario() == unJugador));
		this.habilitarCasilla = true;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public void dibujame(VistaCasilla vistaCasilla) {
		vistaCasilla.dibujarFondo();
		vistaCasilla.dibujarJugadores();
	}
/*
	@Override
	public EventHandler<MouseEvent> obtenerHandler(Image imagen) {
		return new OpcionesCompaniaPoseibleHandler(imagen, (Compania) this.poseible);
	}
*/
}
