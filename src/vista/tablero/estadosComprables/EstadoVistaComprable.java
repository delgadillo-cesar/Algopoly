package vista.tablero.estadosComprables;

import modelo.entidades.Jugador;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import vista.tablero.VistaCasilla;

public abstract class EstadoVistaComprable extends EstadoVista {
	protected boolean habilitarCasilla;

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = this.habilitarCasilla;
		this.habilitarCasilla = false;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador){
		this.habilitarCasilla = true;
	}


	@Override
	public void dibujame(VistaCasilla vistaCasilla) {
		vistaCasilla.dibujarFondo();
		vistaCasilla.dibujarJugadores();
	}

}
