package vista.tablero.poseibles;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioCordobaNorte;
import vista.tablero.VistaTablero;
import Controlador.CompaniaPoseibleHandler;
import javafx.scene.control.Button;

public class VistaCordobaNortePoseible extends Button {

	private BarrioCordobaNorte cordNorte;
	
	public VistaCordobaNortePoseible(){
		this.cordNorte = (BarrioCordobaNorte) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_CORDOBA_NORTE);
		this.setText(cordNorte.propietario().nombreJugador());

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaCordobaNorte.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);

        CompaniaPoseibleHandler edesurPoseidaHandler = new CompaniaPoseibleHandler(cordNorte);
        this.setOnAction(edesurPoseidaHandler);
	}

}
