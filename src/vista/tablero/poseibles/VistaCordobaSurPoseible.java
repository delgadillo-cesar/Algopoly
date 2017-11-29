package vista.tablero.poseibles;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioCordobaSur;
import vista.tablero.VistaTablero;
import Controlador.CompaniaPoseibleHandler;
import javafx.scene.control.Button;

public class VistaCordobaSurPoseible extends Button {

	private BarrioCordobaSur cordSur;
	
	public VistaCordobaSurPoseible(){
		this.cordSur = (BarrioCordobaSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_SUR);
		this.setText(cordSur.propietario().nombreJugador());

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaCordobaSur.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);

        CompaniaPoseibleHandler edesurPoseidaHandler = new CompaniaPoseibleHandler(cordSur);
        this.setOnAction(edesurPoseidaHandler);
	}

}
