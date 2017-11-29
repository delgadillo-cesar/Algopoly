package vista.tablero.poseibles;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioTucuman;
import vista.tablero.VistaTablero;
import Controlador.CompaniaPoseibleHandler;
import javafx.scene.control.Button;

public class VistaTucumanPoseible extends Button {

	private BarrioTucuman tucuman;
	
	public VistaTucumanPoseible(){
		this.tucuman = (BarrioTucuman) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_TUCUMAN);
		this.setText(tucuman.propietario().nombreJugador());

        this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaTucuman.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);

        CompaniaPoseibleHandler tucumanPoseidaHandler = new CompaniaPoseibleHandler(tucuman);
        this.setOnAction(tucumanPoseidaHandler);
	}
}
