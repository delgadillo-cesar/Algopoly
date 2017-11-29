package vista.tablero.poseibles;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioNeuquen;
import vista.tablero.VistaTablero;
import Controlador.CompaniaPoseibleHandler;
import javafx.scene.control.Button;

public class VistaNeuquenPoseible extends Button {

	private BarrioNeuquen neuquen;
	
	public VistaNeuquenPoseible(){
		this.neuquen = (BarrioNeuquen) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_NEUQUEN);
		this.setText(neuquen.propietario().nombreJugador());

	    this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaNeuquen.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_VERTICAL, VistaTablero.ALTO_CASILLA_VERTICAL);

        CompaniaPoseibleHandler neuquenPoseidaHandler = new CompaniaPoseibleHandler(neuquen);
        this.setOnAction(neuquenPoseidaHandler);
	}
}
