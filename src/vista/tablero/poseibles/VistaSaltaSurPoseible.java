package vista.tablero.poseibles;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioSaltaSur;
import vista.tablero.VistaTablero;
import Controlador.CompaniaPoseibleHandler;
import javafx.scene.control.Button;

public class VistaSaltaSurPoseible extends Button {

	private BarrioSaltaSur saltaSur;
	
	public VistaSaltaSurPoseible(){
		this.saltaSur = (BarrioSaltaSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SALTA_SUR);
		this.setText(saltaSur.propietario().nombreJugador());

        this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSaltaSur.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);

        CompaniaPoseibleHandler edesurPoseidaHandler = new CompaniaPoseibleHandler(saltaSur);
        this.setOnAction(edesurPoseidaHandler);
	}
}
