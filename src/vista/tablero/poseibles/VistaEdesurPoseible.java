package vista.tablero.poseibles;

import vista.tablero.VistaTablero;
import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.Edesur;
import Controlador.CompaniaPoseibleHandler;
import javafx.scene.control.Button;

public class VistaEdesurPoseible extends Button {

	private Edesur edesur;
	
	public VistaEdesurPoseible(){
		this.edesur = (Edesur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_EDESUR);
		this.setText(edesur.propietario().nombreJugador());

        this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSaltaNorte.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);

        CompaniaPoseibleHandler edesurPoseidaHandler = new CompaniaPoseibleHandler(edesur);
        this.setOnAction(edesurPoseidaHandler);
	}

}
