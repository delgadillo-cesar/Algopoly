package vista.tablero.poseibles;

import controlador.poseibles.OpcionesBarrioPoseibleHandler;
import modelo.entidades.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioCordobaSur;
import vista.tablero.VistaCasilla;
import javafx.scene.image.Image;

public class VistaCordobaSurPoseible extends VistaCasilla {

	private BarrioCordobaSur cordSur;
	
	public VistaCordobaSurPoseible(){
		this.cordSur = (BarrioCordobaSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_SUR);

		this.stringImagen = "file:src/vista/imagenes/CasillaCordobaSur.png";
        this.dibujarCasilla();

        OpcionesBarrioPoseibleHandler opcionesBarrioPoseibleHandler = new OpcionesBarrioPoseibleHandler(imagen, cordSur);
		this.setOnMouseClicked(opcionesBarrioPoseibleHandler);
	}

	@Override
	public void habilitarParaJugador(Jugador unJugador) {
		this.setDisable(!(cordSur.propietario() == unJugador));
	}

}
