package vista.tablero.poseibles;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.Tren;
import vista.tablero.VistaTablero;
import Controlador.CompaniaPoseibleHandler;
import javafx.scene.control.Button;

public class VistaTrenPoseible extends Button {

	private Tren tren;
	
	public VistaTrenPoseible(){
		this.tren = (Tren) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_TREN);
		this.setText(tren.propietario().nombreJugador());

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaTren.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);

        CompaniaPoseibleHandler trenPoseidaHandler = new CompaniaPoseibleHandler(tren);
        this.setOnAction(trenPoseidaHandler);
	}
}
