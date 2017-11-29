package vista.tablero.poseibles;

import modelo.tablero.Tablero;
import modelo.tablero.casillas.poseibles.barrios.BarrioSantaFe;
import vista.tablero.VistaTablero;
import Controlador.CompaniaPoseibleHandler;
import javafx.scene.control.Button;

public class VistaSantaFePoseible extends Button {

	private BarrioSantaFe santaFe;
	
	public VistaSantaFePoseible(){
		this.santaFe = (BarrioSantaFe) Tablero.getInstance().obtenerCasilla(Tablero.CASILLA_SANTA_FE);
		this.setText(santaFe.propietario().nombreJugador());

		this.setStyle("-fx-background-image: url('/vista/imagenes/CasillaSantaFe.png')");
        this.setMinSize(VistaTablero.ANCHO_CASILLA_HORIZONTAL, VistaTablero.ALTO_CASILLA_HORIZONTAL);

        CompaniaPoseibleHandler santaFePoseidaHandler = new CompaniaPoseibleHandler(santaFe);
        this.setOnAction(santaFePoseidaHandler);
	}
}
