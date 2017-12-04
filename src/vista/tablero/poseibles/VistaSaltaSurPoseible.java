package vista.tablero.poseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioSaltaSur;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaSaltaSurPoseible extends VistaCasilla {

	private BarrioSaltaSur saltaSur;
	
	public VistaSaltaSurPoseible(){
		this.saltaSur = (BarrioSaltaSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SALTA_SUR);

		this.stringImagen = "file:src/vista/imagenes/CasillaSaltaSur.png";
        this.dibujarCasilla();

		OpcionesBarrioPoseibleHandler opcionesBarrioPoseibleHandler = new OpcionesBarrioPoseibleHandler(imagen, saltaSur);
		this.setOnMouseClicked(opcionesBarrioPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(saltaSur.propietario() == unJugador));
	}
}
