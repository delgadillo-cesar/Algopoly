package vista.tablero.estadosPoseibles;

import modelo.entidades.Jugador;
import modelo.tablero.poseibles.barrios.Barrio;
import vista.Algopoly;
import vista.jugador.VistaJugador;
import vista.tablero.EstadoVista;
import vista.tablero.VistaCasilla;
import vista.tablero.casilla.VistaCasillaBarrio;

public abstract class BarrioEstadoVistaPoseible extends EstadoVista {

	protected Barrio barrio;
	protected boolean habilitarCasilla;

	@Override
	public boolean habilitarParaJugador(Jugador unJugador) {
		boolean habilitar = ((this.habilitarCasilla) && (barrio.propietario() == unJugador));
		this.habilitarCasilla = true;
		return habilitar;
	}

	@Override
	public void jugadorCayoEnCasilla(VistaJugador unJugador) {
	}

	@Override
	public void dibujame(VistaCasilla vistaCasilla) {
		vistaCasilla.dibujarFondo();
		((VistaCasillaBarrio) vistaCasilla).setConstruccion(this.barrio.construccionActual());
		((VistaCasillaBarrio) vistaCasilla).dibujarConstruccion();
		vistaCasilla.dibujarJugadores();
		
		VistaJugador vj = Algopoly.getInstance().obtenerVistaJugador(barrio.propietario());
		vistaCasilla.dibujarMarco(vj.getColor());
	}

}
