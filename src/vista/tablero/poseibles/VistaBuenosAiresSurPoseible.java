package vista.tablero.poseibles;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioBuenosAiresSur;
import vista.tablero.VistaTablero;
import Controlador.BarrioPoseibleHandler;
import javafx.scene.control.Button;

public class VistaBuenosAiresSurPoseible extends Button {

	private BarrioBuenosAiresSur bueSur;
	
	public VistaBuenosAiresSurPoseible(){
		this.bueSur = (BarrioBuenosAiresSur) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_BUENOS_AIRES_SUR);
		this.setText(bueSur.propietario().nombreJugador());

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaBuenosAiresSur.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);

        BarrioPoseibleHandler buenosAiresSurPoseidaHandler = new BarrioPoseibleHandler(bueSur);
        this.setOnAction(buenosAiresSurPoseidaHandler);
	}

}
