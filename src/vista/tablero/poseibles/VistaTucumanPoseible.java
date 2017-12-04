package vista.tablero.poseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioTucuman;
import vista.tablero.VistaCasilla;

public class VistaTucumanPoseible extends VistaCasilla {

	private BarrioTucuman tucuman;
	
	public VistaTucumanPoseible(){
		this.tucuman = (BarrioTucuman) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_TUCUMAN);

		this.stringImagen = "file:src/vista/imagenes/CasillaTucuman.png";
        this.dibujarCasilla();

        OpcionesBarrioPoseibleHandler opcionesBarrioPoseibleHandler = new OpcionesBarrioPoseibleHandler(imagen, tucuman);
		this.setOnMouseClicked(opcionesBarrioPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(tucuman.propietario() == unJugador));
	}
}
